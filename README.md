- [1. 실행 방법](#1-실행-방법)
- [2. 테스트 결과](#2-테스트-결과)
- [3. 구현 방법](#3-구현-방법)
- [4. 개선할 점](#4-개선할-점)

---

# 계산기 프로그램

Java Calculator는 Java와 Gradle을 사용하여 구현된 간단한 계산기 프로젝트입니다. <br> 
기본 산술 연산(덧셈, 뺄셈, 곱셈, 나눗셈)을 지원합니다.


# 1. 실행 방법
<a id="1-실행-방법"></a>

```bash
# 경로 : 프로젝트 루트

# gradlew 권한 부여
chmod +x gradlew

# 프로젝트 빌드
./gradlew clean build

# JAR 파일 실행
java -jar ./build/libs/java-calculator-1.0-SNAPSHOT.jar
```

<br>

# 2. 테스트 결과
<a id="2-테스트-결과"></a>

- 총 40개의 단위 테스트를 작성하였습니다.

<img width="647" alt="image" src="https://github.com/donggi-lee-bit/java-calculator/assets/73376468/c124e202-6289-4deb-ae27-c11c6833964b">


<br>

# 3. 구현 방법
<a id="3-구현-방법"></a>

### 기본 산술 연산

- 덧셈, 뺄셈, 곱셈, 나눗셈의 기본 산술 연산을 구현하였습니다. 사용자로부터 입력받은 두 수에 대해 선택된 연산을 수행하고 결과를 반환합니다.
- 연산은 Calculator 클래스에서 수행되며, 각 연산은 Operator enum을 통해 정의되었습니다.

### 테스트 코드 작성

- JUnit을 사용하여 핵심 기능에 대한 단위 테스트를 작성하였습니다. 이를 통해 로직의 동작을 검증하고, 향후 코드 변경 시 기능의 올바른 동작을 지속적으로 확인할 수 있습니다.

# 4. 개선할 점
<a id="4-개선할-점"></a>

- 동적 정밀도 값 주입
  - 현재 계산 결과의 정밀도가 1로 고정되어 있습니다. 이는 모든 연산 결과가 소수점 첫째 자리까지만 표시되고, 이후의 자릿수는 반올림되어 처리됩니다. 이러한 설계는 단순한 계산에는 충분할 수 있으나, 보다 정밀한 계산을 요구하는 사용자의 필요를 충족시키지 못할 수 있습니다.
  - 추후 사용자가 계산 결과의 정밀도를 동적으로 조정할 수 있게 하여, 다양한 사용 사례에 대응할 수 있는 유연성을 제공할 것입니다. 
