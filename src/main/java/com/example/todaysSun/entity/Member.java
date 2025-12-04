package com.example.todaysSun.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "비어 있을 수 없습니다.")
    @Column(unique = true)
    private String loginId; //로그인 ID

    @NotBlank(message = "비어 있을 수 없습니다.")
    private String name; //사용자 이름

    @NotBlank(message = "비어 있을 수 없습니다.")
    private String password;

}