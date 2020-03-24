### 안드로이드 스튜디오 프로젝트 디렉토리 구조

---

**app**

+- manifest	: 앱의 모든 설정내용 (AndroidManifest.xml)

+- java	: 실제 프로그램 파일 (자바(코틀린) 클래스 파일, MainActivity.java(kt))

+- res	: 뷰, 레이아웃 관련 파일 (UI 관련)

​	+- drawable	: 이미지 관련 파일들

​	+- layout	: 레이아웃 xml 파일들ㅇ (activity_main.xml)

​	+- mipmap	: 앱 아이콘 이미지

​	+- values	: 문자열, 색상 등 앱의 뷰와 관련된 설정 변수들 (strings.xml colors.xml styles.xml)



**Gradle Scripts**

bulid.gradle (:app)

bulid.gradle (:Project name)



### **NullPointException** 피하기 

---

``lateinit`` 을 사용하여 Null 값이 들어가지 않도록 초기화가 가능하다
해당 변수가 필요할 때 초기화가 진행되어 비어있는 Null 값을 넣어주지 않아도 된다.



### **Jetpack**

---





### Kotlin 언어

---

- 변수 선언
  val  : 변하지 않는 변수
  var : 변하는 변수

- Null 안전

  ```kotlin
  val languageName: String = null // 불가
  
  val languageName: String? = null // 가능
  ```

- 조건식

  ```kotlin
  val answerString: String = if (count == 42) {
          "I have the answer."
      } else if (count > 35) {
          "The answer is close."
      } else {
          "The answer eludes me."
      }
  
      println(answerString) // 조건식을 계산하여 answerString 에 바로 넣어줌
  
  
  val answerString = when {
          count == 42 -> "I have the answer."
          count > 35 -> "The answer is close."
          else -> "The answer eludes me."
      }
  
      println(answerString) // when 을 사용하여 코드 가독성을 높일 수 있다
  ```

- 함수

  ```kotlin
  fun generateAnswerString(countThreshold: Int): String {
      val answerString = if (count > countThreshold) {
          "I have the answer
  	} else {
          "The answer eludes me"
      }
      
      return answerString
  }
  
  val answerString = generateAnswerString(42)
  
  // 함수의 다른 표현 방법
  // 1
  fun function(Count: Int): String {
      return if (count > Count) {
          "output1"
      } else {
          "output2"
      }
  }
  // 2
  fun function2(Count: Int): String = if (count > Count ){
              "output1"
          } else {
              "output2"
          }
  
  // 익명 함수
  val LengthOut: (String) -> Int = { input ->
  		input.length
  	}
  
  ```

  

### 기타 개념

---

- **build**
  주로 compile과 비교해서 개념을 잡는다. 컴파일이란 개발자가 작성한 코드를 바이너리 코드로 변환하는 과정을 말한다. 개발자가 이해하는 코드를 컴퓨터의 기계어로 변환하는 작업
  여러개의 소스로 나눠져서 서로의 참조가 필요한 경우 link 를 이용하여 실행한다

  **빌드**는 소스코드 파일을 실행가능한 소프트웨어 산출물로 만드는 포괄적인 작업을 말한다.
  컴파일은 **빌드**에 포함된 작업이라 할 수 있겠다.

  

  ***빌드 프로세스***

  ![이미지](https://developer.android.com/images/tools/studio/build-process_2x.png?hl=ko)

  컴파일러는 소스코드를 DEX(Dalvik Executable) 파일로 변환하고 그 외 모든 것을 컴파일된 리소스로 변화한다. 이 DEX 파일에는 Android 기기에서 실행되는 바이트 코드가 포함 된다

  APK Packager는 DEX 파일과 컴파일된 리소스를 단일 APK로 결합한다. 그러나 앱을 Android 기기에 설치하고 배포할 수 있으려면 먼저 APK에 서명을 해야한다

  APK Packager는 디버그 또는 출시 키 저장소를 사용하여 APK에 서명을 한다

  - 디버그 버전의 앱( 즉, 테스트 및 프로파일링 전용의 앱 )을 빌드 중인 경우에는 패키저가 디버그 키 저장소로 앱을 서명한다. Android Studio는 디버그 키 저장소로 새 프로젝트를 자동으로 구성한다
  - 출시 버전의 앱 (즉, 외부에 출시할 앱 )을 빌드 중인 경우에는 패키저가 출시 키 저장소로 앱을 서명한다

  빌드 프로세스가 끝나면 배포, 테스트 또는 외부 사용자에게 출시할 수 있는 앱의 디버그 apk 또는 출시 apk 가 생성된다

  

  

- 

