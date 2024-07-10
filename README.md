# 서울시 인터넷 쇼핑몰 현황 프로젝트

## 프로젝트 설명

이 프로젝트는 Kotlin과 Spring Boot를 사용하여 서울시 인터넷 쇼핑몰 현황을 모니터링하는 웹 애플리케이션입니다. 이 애플리케이션은 다양한 인터넷 쇼핑몰 사이트의 정보를 수집하고, 필터링된 데이터를
제공합니다.

## 기능

- 전자상거래 사이트 정보 수집 및 저장
- 필터링된 인터넷 쇼핑몰 사이트 목록 조회
- CSV 파일 업로드를 통한 데이터 입력
- 커서 기반 페이지네이션 및 필터 기능

<br/>

## 팀원 소개

<br/>

![image (6)](https://github.com/seoul-e-commerce-monitor/seoul-e-commerce-monitor/assets/161712242/289e90fd-f1a3-4c4f-a74f-a71b62604c4c)
<table align=center>
    <thead>
        <tr >
            <th style="text-align:center;" >류원형</th>
            <th style="text-align:center;" >김보현</th>
            <th style="text-align:center;" >김형섭</th>
            <th style="text-align:center;" >하지호</th>
        </tr>
    </thead>
    <tbody>
        <tr>
<td><a href="https://ibb.co/XytT1N0"><img width="160" src="https://i.ibb.co/SQBpbWY/DALL-E-2024-06-18-22-05-45-An-illustration-of-a-young-boy-who-loves-boxing-and-is-also-a-developer-i.png" alt="DALL-E-2024-06-18-22-05-45-An-illustration-of-a-young-boy-who-loves-boxing-and-is-also-a-developer-i" border="0"></a></td>
<td><a href="https://imgbb.com/"><img width="160" src="https://i.ibb.co/gDq6WWR/167150086.png" alt="167150086" border="0"></a></td>
<td><a href="https://imgbb.com/"><img width="160" src="https://i.ibb.co/z4t29cZ/162294237.png" alt="162294237" border="0"></a></td>
<td><a href="https://imgbb.com/"><img width="160" src="https://i.ibb.co/jgBGtBw/162549235.png" alt="162549235" border="0"></a></td>
        </tr>
        <tr>
            <td><a href="https://github.com/1hyung">@1hyung</a></td>
            <td><a href="https://github.com/ckhcree">@ckhcree</a></td>
            <td><a href="https://github.com/hysup">@hysup</a></td>
            <td><a href="https://github.com/HJH1111">@HJH1111</a></td>
        </tr>
        <tr>
            <td width="160">CRUD<br>협업 툴 </td>
            <td width="160">OpenAPI</td>
            <td width="160">코드 개선<br>Pageable</td>
            <td width="160">QueryDSL<br> 페이지네이션</td>
        </tr>
    </tbody>
</table>                                                     

## <strong>협업 도구</strong>

<br><img alt="Git" src="https://img.shields.io/badge/Git-F05032?style=flat-squre&logo=git&logoColor=white"/>

<br><img alt="GitHub" src="https://img.shields.io/badge/GitHub-181717?style=flat-squre&logo=github&logoColor=white"/>

<br><img alt="Slack" src="https://img.shields.io/badge/Slack-4A154B?style=flat-squre&logo=slack&logoColor=white"/>

<br/>

## <a href="https://www.figma.com/board/9tp3ICiW8Z5K6XbrL9iiQ9/%EC%8B%A4%EC%A0%84%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5%EC%A1%B0?node-id=128-646&t=zWtge9vkIq5qf5xp-0"><strong>Wire frame</strong></a>

<img width="2656" alt="실전프로젝트 5조 (8)" src="https://github.com/seoul-e-commerce-monitor/seoul-e-commerce-monitor/assets/161712242/75103418-4d7e-4f1d-8d63-702789d08767">

<br/>

<br/>

## <a href="https://www.figma.com/board/9tp3ICiW8Z5K6XbrL9iiQ9/%EC%8B%A4%EC%A0%84%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5%EC%A1%B0?node-id=128-646&t=zWtge9vkIq5qf5xp-0"><strong>ERD</strong></a>

<img width="812" alt="실전프로젝트 5조 (9)" src="https://github.com/seoul-e-commerce-monitor/seoul-e-commerce-monitor/assets/161712242/41eaa210-3749-4951-8a41-25ddc6ab74fe">

<br/>

## 사전 준비

이 프로젝트를 로컬에서 실행하기 위해서는 다음이 필요합니다:

- JDK 17 이상
- Gradle 6.8 이상
- PostgreSQL 데이터베이스 (또는 원하는 데이터베이스)

## 설치 및 실행 방법

### 1. 저장소 클론

먼저, GitHub 저장소를 로컬 머신에 클론합니다:

```
git clone https://github.com/your-username/your-repository.git
cd your-repository
```

### 2. 환경 설정

application.yml 파일을 설정합니다. 데이터베이스 설정 예시는 다음과 같습니다:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://your-database-url:5432/your-database
    username: your-database-username
    password: your-database-password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
  servlet:
    multipart:
      maxFileSize: 1000MB
      maxRequestSize: 3000MB

```

## ⚙ 기능 구현 세부사항

```
1. IntelliJ Ultimate 또는 DBeaver를 사용하여 CSV 파일을 데이터베이스 테이블에 입력
2. 업체 리스트 조회 중 필터 기능
    ㆍ전체평가 필터 조회
        ㆍ전체평가는 0점 ~ 3점으로 이루어져 있으며, 점수를 입력하여 해당 업체 리스트만 조회
        ㆍ예) 전체평가가 3점인 경우만 리스트 조회
    ㆍ업소상태 필터 조회
        ㆍ사이트운영중단, 휴업중, 광고용(홍보용), 등록정보불일치, 사이트폐쇄, 영업중, 확인안됨 상태 중 1개를 선택하여 해당 업체 리스트만 조회
    ㆍ모니터링날짜의 내림차순 정렬
    ㆍ상위 10개 리스트 보여주기
3. Pageable 기반 업체 리스트 조회
    ㆍ전체평가와 업소상태 필터를 동시에 적용하여 10개씩 리스트를 보여주는 API 구현
    ㆍ필수 구현 기능 API와 별도의 API로 구현
4. CSV를 데이터베이스에 입력하는 Kotlin 코드
    ㆍ/collection API를 통해 서버 내 특정 위치의 CSV 파일을 1개 행씩 읽어서 Database에 차례대로 insert
5. QueryDSL을 사용한 커서 기반 페이지네이션 및 필터
    ㆍ전체평가와 업소상태 필터를 동시에 적용하여 10개씩 리스트를 보여주는 API 구현
    ㆍ커서 기반 페이지네이션 적용
6. CSV를 데이터베이스에 입력하는 Kotlin 코드 개선
    ㆍ100개씩 읽어서 Database에 입력
    ㆍ1개씩 입력하는 경우 시간이 오래 걸리기 때문
```

## 사용 예제

애플리케이션이 실행되면, 웹 브라우저를 열고 http://localhost:8080/swagger-ui/index.html에 접속합니다. 주요 엔드포인트는 다음과 같습니다:

### 필터링된 전자상거래 사이트 목록 조회

```kotlin
@GetMapping("/api/v1/stores/filter")
fun getAllStoresPage(
    @RequestParam(value = "businessName", required = false) businessName: String?,
    @RequestParam(value = "overallEvaluation", required = false) overallEvaluation: String?,
    @RequestParam(value = "businessStatus", required = false) businessStatus: String?,
    @RequestParam(value = "monitoringDate", required = false) monitoringDate: String?,
    @RequestParam(value = "csvId", required = false) csvId: Long?
): ResponseEntity<List<CsvResponse>> {
    return ResponseEntity.ok(
        storeService.getAllStoresPage(
            businessName,
            overallEvaluation,
            businessStatus,
            monitoringDate,
            csvId
        )
    )
}
```

### 기존의 1개씩 입력하는 코드에서 100개씩 입력하는 코드로 개선

```kotlin
    fun readCsv(file: File) {

    if (file.exists()) {
        println("파일이 존재합니다.")
    } else {
        println("파일이 존재하지 않습니다.")
    }

    val lines = file.readLines()
    var count = 0
    val csvSize = 100
    val csvList = mutableListOf<Csv>()

    lines.forEach { line ->

        val regex = ",".toRegex()
        val data = regex.split(line).map { it.trim('\"') }

        val csv = Csv(
            businessName = data[0],
            mallName = data[1],
            domainName = data[2],
            phoneNumber = data[3],
            operatorEmail = data[4],
            salesRegistrationNumber = data[5],
            businessType = data[6],
            initialReportDate = (data[7]),
            companyAddress = data[8],
            businessStatus = data[9],
            overallEvaluation = data[10],
            businessInfoDisplayEvaluation = data[11],
            withdrawalRightEvaluation = data[12],
            paymentMethodEvaluation = data[13],
            termsOfServiceEvaluation = data[14],
            personalInfoSecurityEvaluation = data[15],
            mainProducts = data[16],
            withdrawalPossibility = data[17],
            requiredInitialScreenItems = data[18],
            paymentMethods = data[19],
            complianceWithTermsOfService = data[20],
            personalInfoHandlingPolicy = data[21],
            requestForAdditionalPersonalInfo = data[22],
            purchaseSafetyService = data[23],
            securityServerInstallation = data[24],
            certificationMark = data[25],
            expectedDeliveryDate = data[26],
            withdrawalShippingCostBurden = data[27],
            customerComplaintBoardOperation = data[28],
            membershipWithdrawalMethod = data[29],
            siteEstablishmentYear = data[30],
            monitoringDate = data[31],

            )


        csvList.add(csv)
        if (csvList.size == csvSize) {
            csvRepository.saveAll(csvList)
            count++
            logger.info { "100개씩 insert ${count}번째 successful" }

            csvList.clear()
        }
    }
}
}
```

### CSV 파일 업로드

```kotlin
@PostMapping("/api/v1/stores/collection", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
fun readCsv(@RequestParam("pathfile") multipartFile: MultipartFile) {
    val file = File.createTempFile("csv", ".tmp")
    try {
        multipartFile.transferTo(file)
        storeService.readCsv(file)
    } finally {
        file.delete()
    }
}
```

### CSV 파일 읽기

```kotlin
@PostMapping("/collection")
fun readFromCsv(): ResponseEntity<Unit> {
    return ResponseEntity.ok(csvCodeService.readFromCsv())
}
```

## 트러블 슈팅

### 필터 구현으로 필요 없는 CRUD 제거

![image (7)](https://github.com/seoul-e-commerce-monitor/seoul-e-commerce-monitor/assets/161712242/fc97bf57-87f7-4dd4-a20b-64276d030e4f)

### 문자열 날짜 포맷과 일치하지 않을 때 발생하는 문제

![image](https://github.com/seoul-e-commerce-monitor/seoul-e-commerce-monitor/assets/161712242/2ac39714-af85-40a3-9494-be37c65da4cd)

### 환경설정<br/>

Language : Kotlin<br/>
Framework : Spring Boot<br/>
IDLE : IntelliJ community<br/>
JDK : temurin-17 <br/>
