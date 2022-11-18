package com.s808.data.civilian.model

import android.net.Uri
import com.s808.data.database.enteties.CivilianEntity
import com.s808.data.user.UserGender
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class CivilianProfileTest {

    @Test
    fun `toEntity() maps data properly`() {
        val source = CivilianProfile(
            id = "uuid-uuid-uuid-uuid",
            icon = Uri.parse("file://mock/icon"),
            hasHelmet = true,
            pickMeUpWhereIam = true,
            gender = UserGender.Female
        )
        val entity = source.toEntity()

        assert(entity.userId == source.id)
        assert(entity.icon == "file://mock/icon")
        assert(entity.hasHelmet == source.hasHelmet)
        assert(entity.pickMeUpWhereIam == source.pickMeUpWhereIam)
        assert(entity.gender == source.gender.text)
    }

    @Test
    fun `toProfile() maps data properly`() {
        val entity = CivilianEntity(
            uid = 42,
            icon = "file://mock/icon",
            userId = "uuid-uuid-uuid-uuid",
            hasHelmet = true,
            pickMeUpWhereIam = true,
            gender = "female"
        )

        val profile = entity.toProfile()

        assert(profile.id == entity.userId)
        assert(profile.icon.toString() == "file://mock/icon")
        assert(profile.hasHelmet)
        assert(profile.pickMeUpWhereIam)
        assert(profile.gender is UserGender.Female)
    }
}