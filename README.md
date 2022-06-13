# airbnb
그룹 프로젝트 #4

## 팀명 및 팀원소개

#### 팀명 : 포스 나제? 😎
- 포키, 스타크, 나단, 제이

#### 팀원소개
|Name|Part|Github|
|---|---|---|
|Forky|backend|[Seokho-Ham](https://github.com/seokho-ham)|
|Nathan|backend|[nathan29849](https://github.com/nathan29849)|
|Stark|android|[jminie-o8o](https://github.com/jminie-o8o)|
|Jay|android|[shim506](https://github.com/shim506)|

## WIKI

리포지토리 내 위키에 아래와 같이 팀 내부의 규칙을 정리했습니다.
- [wiki 바로가기](https://github.com/nathan29849/airbnb/wiki)

##  기능
- 현재 단말기 위치에 따른 주요 도시 여행지와의 거리 제공
- 임의로 정리한 앱 정보 및 인증서 다운로드 (포그라운드, 백그라운드 모두 다운 가능)
- 위치, 여행기간, 가격 분포, 성인 어린이 유아의 인원에 따른 숙소 검색
- 구글 Map을 이용한 숙소 위치 제공

## 안드로이드 기술 스택
- Minimum SDK level 21로 98% 이상의 안드로이드 디바이스 지원
- 100% [Kotlin](https://kotlinlang.org/) 기반 + [Coroutines](https://developer.android.com/kotlin/coroutines) + [Flow](https://developer.android.com/kotlin/flow)
- [Jetpack](https://developer.android.com/jetpack)
  - ViewModel
  - LiveData
- Architecture
  - MVVM Architecture ( View - Databinding - ViewModel - Model )
- REST API 통신을 위한 [Retrofit](https://square.github.io/retrofit/)
- DI를 위한 [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- 이미지 로더를 위한 [Coil](https://github.com/coil-kt/coil)
- 페이징 처리를 위한 [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- 상태 처리 및 에러 핸들링을 위한 CallAdapter

| 권한설정 및 위도경도 불러오기  | 키워드 검색 | 날짜, 가격 인원 설정 | 숙소 검색 결과 및 지도 |
|:--------:|:--------:|:--------:|:--------:|
| <img src=https://user-images.githubusercontent.com/79504043/173237033-1510c848-c876-4621-9127-8cec96567699.gif width=200> | <img src=https://user-images.githubusercontent.com/79504043/173237067-44ad303b-fef6-4266-949c-0cd252135e0b.gif width=200> | <img src=https://user-images.githubusercontent.com/79504043/173237631-c4266b00-acdf-4d61-8c4a-765d69adc19a.gif width=200> | <img src=https://user-images.githubusercontent.com/79504043/173238564-e366f104-0b9c-4595-a8b8-8bceb86cfead.gif width=200> |

## MAD Scorecard
<img src="https://user-images.githubusercontent.com/79504043/173233691-3eb89b24-d6ac-41bc-9076-bfe1ea94def6.png">  
<img src="https://user-images.githubusercontent.com/79504043/173233699-4cc2ba9d-9c5e-4276-b3ba-682b233aac70.png">  
<img src="https://user-images.githubusercontent.com/79504043/173233701-1c64b646-42cb-4a04-9847-33215c1c6f22.png">  
