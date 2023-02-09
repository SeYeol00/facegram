package com.facegram.facegrambackend.domain.user

import lombok.NoArgsConstructor
import java.lang.IllegalArgumentException
import javax.persistence.*

@Entity
@NoArgsConstructor
class User constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var username: String

) {
    init{
        if(username.isBlank()){
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    fun updateUsername(name: String){
        this.username = name
    }

    companion object{
        fun newInstance(
            username: String,
            id: Long? = null
        ): User{
            return User(id, username)
        }
    }



}