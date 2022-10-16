package com.roady.roadyapi.roadmap.application.service

import com.roady.roadyapi.global.domain.UnknownIdxException
import com.roady.roadyapi.roadmap.application.port.input.RoadmapUseCase
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapNodePersistenceOutput
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.application.service.factory.RoadmapFactory
import com.roady.roadyapi.roadmap.domain.*
import org.springframework.stereotype.Service

@Service
class RoadmapService(
    private val roadmapPersistenceOutput: RoadmapPersistenceOutput,
    private val roadmapNodePersistenceOutput: RoadmapNodePersistenceOutput,
    private val roadmapFactory: RoadmapFactory
): RoadmapUseCase {
    override fun createRoadmap(create: CreateRoadmap): Long {
        val roadmap = roadmapFactory.of(create)
        val roadmapIdx = roadmapPersistenceOutput.save(roadmap)
        roadmapNodePersistenceOutput.saveAll(roadmapIdx, create.nodes)
        return roadmapIdx
    }

    override fun editRoadmap(edit: EditRoadmap): Long {
        validate(edit)

        val roadmap = roadmapPersistenceOutput.findById(edit.idx)
        val editedRoadmap = roadmapFactory.of(roadmap, edit)

        return roadmapPersistenceOutput.save(editedRoadmap)
    }

    override fun deleteRoadmap(delete: DeleteRoadmap) {
        validate(delete)

        roadmapPersistenceOutput.deleteById(delete.idx)
    }

    private fun validate(edit: EditRoadmap) {
        if(edit.nodes == null && edit.name == null) throw EmptyArgumentException("수정할 내용이 없습니다!")

        if(roadmapPersistenceOutput.existsByIdx(edit.idx)) throw UnknownIdxException("해당 Idx를 가진 로드맵이 존재하지 않습니다!", edit.idx)

        val roadmap = roadmapPersistenceOutput.findById(edit.idx)
        if (roadmap.ownerIdx != edit.accountIdx) throw PermissionDeniedException("로드맵의 소유자만 로드맵을 수정할 수 있습니다! 로드맵 소유자 Idx: ${roadmap.ownerIdx}, 수정 요청자 Idx: ${edit.accountIdx}")
    }

    private fun validate(delete: DeleteRoadmap) {
        if(roadmapPersistenceOutput.existsByIdx(delete.idx)) throw UnknownIdxException("해당 Idx를 가진 로드맵이 존재하지 않습니다!", delete.idx)

        val roadmap = roadmapPersistenceOutput.findById(delete.idx)
        if (roadmap.ownerIdx != delete.accountIdx) throw PermissionDeniedException("로드맵의 소유자만 로드맵을 삭제할 수 있습니다! 로드맵 소유자 Idx: ${roadmap.ownerIdx}, 삭제 요청자 Idx: ${delete.accountIdx}")
    }
}