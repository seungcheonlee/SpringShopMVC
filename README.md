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

