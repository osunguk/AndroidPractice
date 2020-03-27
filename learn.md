### 안드로이드 스튜디오 프로젝트 디렉토리 구조

공부해야할 것

- [ ] 프래그먼트 백스택
- [ ] Intent
- [ ] Fragment Manager
- [ ] 라이프 사이클
- [ ] inflate & inflator
- [ ] it 개념
- [ ] 람다
- [ ] 4대요소 (액티비티, 서비스, 방송 수신자, 콘텐츠 제공자) + a(인텐트, 뷰, 프래그먼트)
- [ ] https://www.androidhuman.com/tag/kotlin/

## Index

[디렉토리 구조](#app)

[Gradle Scripts](#Gradle-Scripts)

[findViewById() 없애기](#findViewById()-없애기)

[NullPointException 피하기](#NullPointException-피하기)

[Activity와 Fragment 차이](#Activity와-Fragment-차이)

[4대 요소](#4대-요소)

[Layout 클래스 종류](#Layout-클래스-종류)

[Kotlin 언어](#Kotlin-언어)

[코틀린과 자바 차이점](#코틀린과-자바-차이점)

[기타 개념](#기타-개념)

---

### **app**

+- manifest	: 앱의 모든 설정내용 (AndroidManifest.xml)

+- java	: 실제 프로그램 파일 (자바(코틀린) 클래스 파일, MainActivity.java(kt))

+- res	: 뷰, 레이아웃 관련 파일 (UI 관련)

	+- drawable	: 이미지 관련 파일들
	
	+- layout	: 레이아웃 xml 파일들ㅇ (activity_main.xml)
	
	+- mipmap	: 앱 아이콘 이미지
	
	+- values	: 문자열, 색상 등 앱의 뷰와 관련된 설정 변수들 (strings.xml colors.xml styles.xml)

[go to Index](#Index)

### **Gradle Scripts**

- bulid.gradle (:app)

  > 개별 모듈을 위한 빌드 스크립트

  크게 3가지로 구분된다. apply plugin 블럭, android 블럭, dependencies 블럭

  1. apply plugin 블럭
     플러그인을 추가할 때 사용 (자체적으로 제작 or 수정도 가능은 하다)

  2. android 블러
     기본적으로 AndroidManifest.xml 의 속성을 재정의하는 목적으로 활용
     (AndroidManifest.xml 보다 우선순위가 높다)

  3. dependencies 블럭

     외부 라이브러리를 관리하기 위한 블럭
     

- bulid.gradle (:Project name)

  > 빌드 스크립트 & 전체 프로젝트 대상

  안드로이드 gradle 플러그인 정보 설정

  보통 하나의 프로젝트에 하나의 모듈이라 크게 건드릴건 없다. ~~아직은 그렇다~~

- settings.gradle

  > 모듈 목록 추가

  내용은 ```include ':app'``` 밖에 없다. 만약 새로운 모듈을 추가한다면 콤마로 추가해주면 된다.

- etc

  - gradle.properties	속성파일
  - local/properties       로컬 속성 파일

[go to Index](#Index)

### findViewById() 없애기

---

[go to Index](#Index)



### **NullPointException** 피하기 

---

``lateinit`` 을 사용하여 Null 값이 들어가지 않도록 초기화가 가능하다
해당 변수가 필요할 때 초기화가 진행되어 비어있는 Null 값을 넣어주지 않아도 된다.

[go to Index](#Index)

### **Jetpack**

---



[go to Index](#Index)

### Activity와 Fragment 차이

---

- Activity
  하나의 화면을 뜻하며 하나의 액티비티 클래스를 가진다. 하나의 클래스는 하나의 XML로 된 레이아웃 파일과 연결된다.
  이런 상황에서 프래그먼트 액티비티란 개념이 나왔다. 간단히 말해서 하나의 액티비티안에 여러개의 액티비티를 보여주고 싶다는 목적으로 사용한다

  (실제로 여러 액티비티를 넣는 것이 아니고 그렇게 보이도록 하는 것)

> 정리하자면
>
> 로직은 하나의 액티비티가 존재하고, 그 액티비티 안에 다른 액티비리티들을 넣고 싶다면
>
> 다른 액티비티들(넣는, 들어가는 액티비티)은 Fragment를 상속받는 액티비티여야 한다



추가) 프래그먼트는 액티비티 내에서 화면 UI의 일부를 나타낸다. 여러 개의 프래그먼트를 조합하여 액티비티가 출력하는 한 화면의 UI를 구성할 수 있으며 하나의 프래그먼트는 재사용성을 가진다

프래그먼트는 액티비티처럼 생명주기를 가지고 있으며 액티비티 실행 중에도 화면에 동적으로 추가되거나 다른 프래그먼트로 교체가 가능하다

기본적으로 한 개의 액티비티에 들어가는 화면 요소를 프래그먼트 단위로 나누어 관리하기 때문에 레아웃을 분리 관리할 수 있고, 액티비티의 화면 구성을 위한 레이아웃의 복잡도도 줄일 수 있다.

[go to Index](#Index)



### 4대 요소

---

- UI 화면을 나타내는 액티비티
  액티비티는 사용자가 바라보는 인터페이스 화면을 가지고 있는 요소이며 레이아웃 파일로 구성한다. 실제 앱에서 동작하는 코드가 필요하며 이벤트를 처리하고 UI를 갱신한다

  하나의 앱은 하나 이상의 액티비티를 가지며 하나의 액티비티는 여러 프래그먼트를 가질 수 있다

  액티비티를 시작시켜주는 주체는 메인 스레드이며 액티비티를 제어하고 통제

- 방송 수신자
  안드로이드에서 발생하는 다양한 이벤트 및 정보를 받고 전달하는 요소

- 콘텐츠 제공자
  데이터를 관리하거나 다른 애플리케이션에 데이터를 제종하는 요소

- Intent 
  안드로이드 4대 요소 간에 메세지를  전달한다

  2가지로 나뉘며 묵시적 인텐트와 명시적 인텐트가 있다 
  묵시적 인텐트는 특정 클래스를 지정하지 않기 때문에 여러 개의 연관된 요소를 호출할 수 있다는 장점이 이다

- 핸들러와 메세지 큐 







[go to Index](#Index)

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

[go to Index](#Index)

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

[go to Index](#Index)


### 코틀린과 자바 차이점

----

1. **변수/상수**

java

```java
String strVar = "";			// 변수
final String strVal = ""	// 상수
```

Kotlin

```kotlin
var strVar: String = "" 	// 변수
val strVar: String = ""		// 상수
```

2. **NRE**

java

```java
@Nullable String strNullable = null;
@NonNull String strNonNull = "";

if (strNonNull != null){
    strNonNull.split('/');
}
```

kotlin

```kotlin
var strNullable: String? = null
var strNonNull" String = ""

strNullable?.split('/')
```

3. **getter / setter**

java

```java
PersonKotlin person = new PersonKotlin("hellojdh",40,123,1234);
String name = person.getName();
int age = person.getAge();
int tall = person.getTall();
int person_id = person.getPerson_id();
person.toString();
person.hashCode();
```

kotlin

```kotlin
var person = PersonKotlin("hellojdh",25,176,12345)
var name = person.name
var age = person.age
var tall = person.tall
var person_id = person.person_id
person.toString()
person.hashCode()
```

4. **변수 출력**

java

```java
String ex1 = "예제입니다.";
int ex2    = 1;
System.out.println("예제의 결과는 :: "+ex1+" 숫자는 :: "+ex2);
```

kotlin

```kotlin
var ex1 = "예제입니다."
var ex2 = 1
println("예제의 결과는 :: $ex1 숫자는 :: $ex2")

var person = PersonKotlin("hellojdh",123,456,12345,PersonKotlin.Cloth(1,2))
println("이름은 ${person.name} 이며, 나이는 ${person.age} 입니다.")
```

5. **상속**

java

```java
pubic class Mainactivity extends AppCompatActivity { ... }
```

kotlin

```kotlin
class MainactivityKt : AppCompatActivity, OnclickListener { ... }
// 인터페이스 추가는 , 로 추가
```

6. **함수 표현**

```
// Java
[public/private/protected] ReturnType 함수이름(Type 변수들){
  [return]
}

// Kotlin
[public/private/protected] fun 함수이름(Type 변수들): ReturnType{
  [return]
}
```

7. **클래스 표현법**

```
// Java
public class Person {
  private final String name;
  public Person(String name){
    this.name = name;
  }
}

// Kotlin
class Person constructor(val name: String){}
```

[go to Index](#Index)





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

- WYSIWYG

  > <u>W</u>hat <u>Y</u>ou <u>S</u>ee <u>I</u>s <u>W</u>hat <u>Y</u>ou <u>G</u>et
  > 보이는 대로 얻는다!
  >
  > [go to Index](#Index)

[go to Index](#Index)