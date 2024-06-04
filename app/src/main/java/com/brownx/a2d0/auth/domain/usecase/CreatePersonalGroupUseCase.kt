package com.brownx.a2d0.auth.domain.usecase

import android.content.SharedPreferences
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.util.GenerateUuid
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
class CreatePersonalGroupUseCase @Inject constructor(
    private val prefs: SharedPreferences
) {
    operator fun invoke(): Group {
        return Group(
            groupId = GenerateUuid().invoke(),
            groupName = "personal",
            groupOwnerId = prefs.getString("username", null)!!,
            createDate = System.currentTimeMillis()
        )
    }
}