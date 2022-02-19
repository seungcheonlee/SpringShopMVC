# SpringShopMVC
My Spring MVC pattern Shop project.

1. Shop 프로젝트 진행 목적
- 팀프로젝트에서 수행하지 못했던 장바구니, 파일업로드, 상품등록 등을 개인 프로젝트에서 연습하고 googleChart API를 이용하여 간단한 백엔드 차트분석을 경험하기 위함.

2. 개발환경
<img width="865" alt="스크린샷 2022-02-19 오후 6 01 40" src="https://user-images.githubusercontent.com/85739056/154794233-a1d6d691-8c38-44c6-b707-1a9604a56943.png">

3. 프로젝트 구조
<img width="399" alt="스크린샷 2022-02-19 오후 6 09 36" src="https://user-images.githubusercontent.com/85739056/154794488-65e7a676-91c7-4164-a66f-eebabb8b9e45.png">
<img width="473" alt="스크린샷 2022-02-19 오후 6 09 29" src="https://user-images.githubusercontent.com/85739056/154794495-2a11d652-f930-4385-8e5e-c1a7524115ad.png">
<img width="447" alt="스크린샷 2022-02-19 오후 6 09 20" src="https://user-images.githubusercontent.com/85739056/154794498-d1c96c83-c0ca-402f-ac0b-fb6384ef1312.png">
<img width="438" alt="스크린샷 2022-02-19 오후 6 09 11" src="https://user-images.githubusercontent.com/85739056/154794504-854f5253-09b1-429c-b8a7-0c5e4311c9c0.png">

4. 주요 기능 로직
<img width="455" alt="스크린샷 2022-02-18 오후 11 04 09" src="https://user-images.githubusercontent.com/85739056/154794582-1f4042a1-084f-4b05-befa-3a27bdc53259.png">
<img width="573" alt="스크린샷 2022-02-18 오후 11 03 55" src="https://user-images.githubusercontent.com/85739056/154794586-3fbfc53d-d646-4123-94fe-428f819e3e4f.png">
<img width="542" alt="스크린샷 2022-02-18 오후 11 03 41" src="https://user-images.githubusercontent.com/85739056/154794588-ac56ca4a-6bb3-4eb9-8cac-917bc01ebcf3.png">
<img width="749" alt="스크린샷 2022-02-18 오후 11 10 37" src="https://user-images.githubusercontent.com/85739056/154794652-e81ca047-e576-4436-9c5d-6ea932407d17.png">
- 개발환경 설정 poo.xml(fileupload, mybatis, json&ajax, 첨부파일 디렉토리 설정)

<img width="747" alt="스크린샷 2022-02-18 오후 11 11 20" src="https://user-images.githubusercontent.com/85739056/154794696-efe7fbe7-68f3-43d4-ae45-722433f9cc6a.png">
- 첨부파일 업로드, UUID 를 사용하여 첨부파일 이름이 겹치지 않도록 고유 식별자를 부여.
<img width="1043" alt="스크린샷 2022-02-19 오후 6 19 18" src="https://user-images.githubusercontent.com/85739056/154794816-63653289-8336-459e-905a-b01df2c1121e.png">
- 세션 로그인 구현(String 변수 name을 통해 로그인시 jsp view에서 sessionScope.name 을 통해 자동으로 로그인 유저 이름 보이게하는 기능 설정도 있음.
<img width="1053" alt="스크린샷 2022-02-19 오후 4 06 58" src="https://user-images.githubusercontent.com/85739056/154794910-a515788c-fe12-4c37-93a7-32f5992414a8.png">
- 배포 디렉토리 설정, 실제 서비스 경로(로컬에서 개발한 디렉토리와 배포시 디렉토리 구별) 임시 디렉토리를 transferto를 통해 첨부파일이 지정된 디렉토리에 복사. 없으면 기존 정보 가져와서 셋팅
<img width="1053" alt="스크린샷 2022-02-19 오후 4 33 19" src="https://user-images.githubusercontent.com/85739056/154794989-b0c5323f-aba4-4a5c-b208-5c91ea852530.png">
<img width="784" alt="스크린샷 2022-02-19 오후 5 32 29" src="https://user-images.githubusercontent.com/85739056/154794995-d7180cb1-aab6-429b-8dca-50dbbb065f49.png">
<img width="711" alt="스크린샷 2022-02-19 오후 5 32 34" src="https://user-images.githubusercontent.com/85739056/154794998-130e2e63-7ee5-4f9a-b893-ad95efdf2487.png">
- 상품 등록 jsp에서 sessionScope를 이용해 로그인이 아닐 경우 상품 수정으로 이동하는 기능, 상품 등록도 함께 가능. 장바구니는 session 값이 존재할 때 이용 가능.
- 장바구니의 상품은 여러개 일 수 있어서 배열을 사용함. 장바구니는 시퀀스로 자동 등록된 int[]형인 cart_id를 for문으로 돌면서 amount의 수량이 0이면 자동 삭제하도록 설정함
- 장바구니 리스트에서 HashMap을 사용하여 key, value의 형태로 전체합계, 배송료 계산 등의 데이터를 map에 저장후 ModelAndView의 addObject를 통해 객체에 담아 cart_list로 전달
<img width="692" alt="스크린샷 2022-02-19 오후 6 29 15" src="https://user-images.githubusercontent.com/85739056/154795191-b2d8d009-3fe3-4dd5-bbea-57457a307ae0.png">
<img width="809" alt="스크린샷 2022-02-19 오후 6 28 47" src="https://user-images.githubusercontent.com/85739056/154795194-fa957a33-5ded-4bbd-a95f-706c04ec131b.png">
<img width="649" alt="스크린샷 2022-02-19 오후 6 28 58" src="https://user-images.githubusercontent.com/85739056/154795200-189a1c65-51eb-4818-aed4-c41f48d4e226.png">
- 구글 차트 API 셋팅
- cart_DAO를 의존 주입하여 List와 제네릭을 사용해 json 형태로 객체를 생성(JSONObject)
- 향상된 for문을 사용해 cartDTO에 저장되었던 상품이름, 가격을 get 메소드로 호출하여 객체에 저장
- 전체 객체가 body.add를 통해 전체 객체를 바디에 추가함.
- 구글 라이브러리 함수 chart.draw를 통해 구글 차트 데이터 시각화 구현.

5. 주요 기능 구현 완성 페이지
<img width="706" alt="스크린샷 2022-02-19 오후 4 24 09" src="https://user-images.githubusercontent.com/85739056/154795410-f3ee00c4-d0d1-4681-b743-4e85c8c99d04.png">
<img width="1231" alt="스크린샷 2022-02-19 오후 4 21 26" src="https://user-images.githubusercontent.com/85739056/154795415-b7562727-ea36-4f73-9484-cfd5f945f05b.png">
<img width="655" alt="스크린샷 2022-02-19 오후 4 25 46" src="https://user-images.githubusercontent.com/85739056/154795419-f125f87c-9395-4fb4-8990-af900d27cecd.png">
<img width="841" alt="스크린샷 2022-02-19 오후 4 26 23" src="https://user-images.githubusercontent.com/85739056/154795421-a6b1dca3-56da-4187-b2b5-453813a8cd79.png">
<img width="1244" alt="스크린샷 2022-02-19 오후 5 36 15" src="https://user-images.githubusercontent.com/85739056/154795426-c3491452-f378-40f7-9264-6b7ac5cd5af4.png">
<img width="833" alt="스크린샷 2022-02-19 오후 6 37 16" src="https://user-images.githubusercontent.com/85739056/154795450-88d1f694-3f75-43cb-a0fd-0c667a80fc47.png">
