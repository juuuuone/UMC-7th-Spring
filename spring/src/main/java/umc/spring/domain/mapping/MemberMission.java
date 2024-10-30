package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Member;  // Member 클래스 import가 필요
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)  // 기본 fetch 전략을 LAZY로 설정
    @JoinColumn(name = "member_id")     // 외래키 설정
    private Member member;              // Member 엔티티와의 연관 관계 필드

    @ManyToOne(fetch = FetchType.LAZY)  // Mission 엔티티와의 관계를 나타냅니다.
    @JoinColumn(name = "mission_id")    // 외래키는 mission_id로 설정됩니다.
    private Mission mission;            // Mission 엔티티와의 연관 관계 필드

}
