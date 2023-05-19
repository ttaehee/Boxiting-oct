# Daily Dust
> particulate matter checker    
> [공공 api](https://www.data.go.kr/data/15073861/openapi.do)를 활용한 지역별 미세먼지 농도를 확인할 수 있는 서비스입니다    
> 2023.05.14 - 2023.05.17    

<br/>

## Flow
1. 공공 api의 `지역 이름 데이터`는 데이터베이스에 저장해둔다
2. 사용자는 데이터베이스에 저장된 지역 목록 중 `미세먼지 농도를 확인하고 싶은 지역(시,도와 측정소)`을 선택한다     
3. 시,도와 측정소를 선택하면 공공 api를 호출해 받은 응답을 가공하여 `해당 지역의 미세먼지 농도와 등급`을 보여준다

<br/>

## Stack
- JAVA 17, SpringBoot 2.7.8
- SpringBoot Web, MySQL, Spring Data JPA, Lombok, Spring Cloud Starter, Thymeleaf

<br/>

## ERD
<img width="722" alt="스크린샷 2023-05-18 오후 12 45 35" src="https://github.com/ttaehee/particulate-matter-checker/assets/103614357/6ed7b4d8-5982-4400-8db9-654903461fe4">

<br/>

## Run

![KakaoTalk_Video_2023-05-18-13-28-58_AdobeExpress 오후 1 46 56](https://github.com/ttaehee/particulate-matter-checker/assets/103614357/36b99d0c-090b-4de3-b74d-93f39a26e425)
