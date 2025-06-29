# 👏여행가유(Android)

<img src="https://user-images.githubusercontent.com/51365114/119624857-8ac2ae00-be44-11eb-8431-62033ba55a62.png"   width="400" height="500"/>


- '2020 빅데이터 분석 및 아이디어 공모전'에 아이디어분야로 보고서를 제출 후 1,2차 통과후 3차 발표평가에 뽑혀 프로토타입으로 개발 했던 어플리케이션입니다.
- 대전 여행에 필요한 모든 서비스를 비대면으로 결제하고 제공 받을 수 있는 앱입니다.

<br/><br/>
**개발기간** 

- **보고서 작성** : 2020/04/30 ~ 2020/05/20 (3주)
- **어플리케이션 개발** : 2020/06/27 ~ 2020/07/02 (6일)

**기여도**

- **70%, 3인 프로젝트(발표 담당1명, 안드로이드 2명)**


<br/><br/>

## 시연영상(클릭👆)



[![Video Label](http://img.youtube.com/vi/AWYBkP480LQ/0.jpg)](https://youtu.be/AWYBkP480LQ)

<br/><br/>
## ✏️담당업무


- **자료**
    - 공공데이터포털 사이트에서 대전 관광 관련 자료 데이터 수기로 엑셀 정리
- **어플리케이션**
    - **메인화면**
        - 축제,홍보 목록 및 상세화면 기능 구현
    - **여행카테고리화면**
        - 드슈,하슈,사슈,자슈,타슈 UI 및 기능 구현
            - 드슈(맛집정보), 사슈(기념품가게정보), 자슈(호텔 및 숙박업소 정보), 하슈(관광지정보), 타슈(대중교통 구매권)
        - 하슈화면에서 대청호 오백리길 지도 마커 10개 찍기
    - **결제화면**
        - zxing 라이브러리 사용
        - 메뉴 결제시 메뉴,시간 선택하는 화면 UI  및 기능 구현

<br/><br/>
## 📱기능


- **메인화면**
    - 온통대전 금액 확인
    - 스탬프 갯수 확인
    - 대전 축제 및 홍보프로그램 확인
- **여행화면**
    - 드슈,사슈,자슈,하슈,타슈 여행카테고리 확인
    - 여행 카테고리별 여행 정보 확인
        - 드슈(맛집정보), 사슈(기념품가게정보), 자슈(호텔 및 숙박업소 정보), 하슈(관광지정보), 타슈(대중교통 구매권)
    - 여행 정보 상세페이지
- **결제화면**
    - QR코드, 바코드 인식으로 결제 메뉴 화면으로 이동
    - 결제 메뉴 화면에서 기념품 갯수 및 예약하기 기능을 통해 비대면으로 결제 가능
    - 결제 후 해당 서비스 알림창

<br/><br/>
## 🎞️상세내용


- **기획배경**
    - '노잼도시' 라는 별명을 가지고 있는 대전광역시이지만, 실제로는 '대청호 오백리길', '장태산 휴양림'같은 관광지가 있다는 것을 알게 되었고, 이러한 강점을 살려 대전의 관광에 도움을 줄 수 있는 아이디어를 기획해보기로 했다.
- **기획내용**
    - 관광객들은 시간과 돈을 '결제'라는 행동을 통해 소비 한다. 따라서 결제라는 행동을 데이터화시킬 수 있는 플랫폼을 만들 수 있다면, 우리가 원하는 데이터를 생산할 수 있다는 생각을 했다.
    - 대전광역시는 이미 '온통대전'이라는 결제 플랫폼을 가지고 있고, 여기에 '언택트'라는 새로운 서비스 트렌드를 접목시킨다면 대전광역시 관광산업에 도움을 줄 수 있을 것 같다는 생각을 했다.
- **기대효과**
    1. 부족한 관광예산을 효과적으로 사용할 수 있다.
    2. 코로나 확산으로 심각한 타격을 받은 관광산업에 대안을 제시할 수 있다.
    3. '여행가유'라는 어플리케이션을 통해 다양한 종류의 데이터들을 생산하고, 활용한다면 대전광역시에서 추진하고 있는 빅데이터 기반 구축 사업에도 도움이 될 수 있다.

![image](https://user-images.githubusercontent.com/51365114/119624927-9ada8d80-be44-11eb-80d1-498a89248392.png)


![image](https://user-images.githubusercontent.com/51365114/119625865-9d89b280-be45-11eb-9837-84d7864158b3.png)

![image](https://user-images.githubusercontent.com/51365114/119624956-a463f580-be44-11eb-9975-be7eab7c26bc.png)

![image](https://user-images.githubusercontent.com/51365114/119624971-a8901300-be44-11eb-83b0-0950e83443e8.png)


<br/><br/>
## 🛠️사용기술

- android(JAVA)
- zxing
- lottie
- Google Maps Android API
- Maps SDK for Android Utility Library

<br/><br/>
## 💡프로젝트 회고

- **체계적인 프로세스의 중요성**
    - 아이디어를 기획하기 위해 우선 대전광역시에 대한 정보부터 수집해야 했습니다. 대전광역시에 관련된 정보들을 찾고, 분류하려 하였지만 그 자료가 너무 많아 정보를 확인하는데에만 굉장히 많은 시간이 걸렸습니다. 따라서,  팀원들과 회의를 통해 데이터를 볼 때 3가지 규칙을 정했습니다.
    1. 그 데이터를 왜 봐야하는지 (가설)
    2. 그 데이터는 무엇을 말해주는지 (검증)
    3. 그 데이터를 어떻게 만들어 졌는지 (확인)
    - 이 3가지의 규칙을 통해 데이터의 우선 순위를 정하여 좀 더 효율적으로 데이터들을 정리 할 수 있었습니다
- **"왜??" 라는 질문을 습관화 해야 함.**
    - 좋은 아이디어를 생각하기 위해서는 끊임없는 질문을 해야 했습니다. 수십 수백 개의 질문 중에서 좋은 아이디어의 실마리가 될 수 있는 단 하나의 질문이 나올 수 있기 때문입니다. 또한 왜라는 질문을 통해 다양한 생각들을 할 수 있게 되었습니다.
- **실현가능성에 대한 아쉬움.**
