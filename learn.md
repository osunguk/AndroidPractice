### 안드로이드 스튜디오 프로젝트 디렉토리 구조

---

**app**

+- manifest	: 앱의 모든 설정내용 (AndroidManifest.xml)

+- java	: 실제 프로그램 파일 (자바(코틀린) 클래스 파일, MainActivity.java(kt))

+- res	: 뷰, 레이아웃 관련 파일 (UI 관련)

	+- drawable	: 이미지 관련 파일들
	
	+- layout	: 레이아웃 xml 파일들ㅇ (activity_main.xml)
	
	+- mipmap	: 앱 아이콘 이미지
	
	+- values	: 문자열, 색상 등 앱의 뷰와 관련된 설정 변수들 (strings.xml colors.xml styles.xml)



**Gradle Scripts**

bulid.gradle (:app)

bulid.gradle (:Project name)



### **NullPointException** 피하기 

---

``lateinit`` 을 사용하여 Null 값이 들어가지 않도록 초기화가 가능하다
해당 변수가 필요할 때 초기화가 진행되어 비어있는 Null 값을 넣어주지 않아도 된다.



### **Jetpack**

---



### Layout 클래스 종류

---

- LinearLayout
  선형으로 된 레이아웃 구조로 View 들을 가로 또는 세로로 나열할 때 사용하는 클래스
  크기와 관계없이 한줄로 배열되며 자식들은 중첩되지 않고 stack 처럼 쌓인다
  - Layout Weight
  위젯들의 영역을 고정 치수가 아닌 전체 영역 대비 비율의 개념으로 지정할 수 있다
- RelativeLayout
  상대적인 위치를 설정하여 레이아웃을 구성할 수 있는 클래스
  자유도가 높은 만큼 조절하는 난이도도 까다로워서 여러 클래스와 섞어 쓰면서 개발하는게 좋다
  자식들 간에 중첩이 되기때문에 세밀한 조절이 필요하다
- FrameLayout
  주로 하나의 자식 View 위젯만 표시할 때 사용하는 클래스
  여러 Fragment를 동일한 위치 내에서 교체하여 표시하고자 할 때, 컨테이너처럼 사용할 수 있다
- TableLayout
  자식들을 행과 열로 나누어 표시하는 클래스
- ListView & GridView
  이름은 View로 되어있지만 Layout 클래스의 종류들
  ![리스트 뷰와 그리드 뷰](https://t1.daumcdn.net/cfile/tistory/23148E39579842EB19)



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