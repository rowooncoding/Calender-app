# Calender-app
> 구글 캘린더 처럼 만들어보기

# 요구사항 정의서
# 일정관리 프로그램

- 구글 캘린더 등 일정을 관리할 수 있는 서비스
- Java 기반으로 작성 되었으며 콘솔에서 결과를 확인할 수 있습니다.

# 요구사항

일정관리 프로그램의 요구사항은 다음과 같습니다.

## 일정의 유형

- 미팅, 할일, 방해금지 시간, 외출 에 대한 일정을 관리할 수 있다.
    - 미팅 : `meeting`
    - 할 일 : `to-do`
    - 방해 금지 시간 : `no-disturbance`
    - 외출 : `out-of-office`

## 등록 (Create)

- 일정을 등록할 수 있다.
    - 겹치는 일정이 존재하면 일정을 등록할 수 없다.
- 일정을 .`csv` 파일로 대량 등록할 수 있다.

## 검색/조회 (Read)

- 일정을 ID, 이름, 기간으로 검색할 수 있다.
- 특정 일자를 입력하면 해당 일자에 등록된 일정을 요약하여 보여준다.

## 수정 (Update)

- 일정을 수정할 수 있다.
- 삭제된 일정을 수정할 수 없다.

## 삭제 (Delete)

- 일정을 삭제할 수 있다.
- Soft-delete로 처리한다.

# 시스템 디자인 및 설계
# 도메인

```java
// enum을 사용하여 추후에 기능을 추가할 수 있게끔
public enum EventType {
	MEETING,
	TO-DO,
	NO_DISTURBANCE,
	OUT_OF_OFFICE,
	;
}

// 이벤트로 묶을 수 있을 것 같아서 인터페이스로 만든다
public interface Event{
	// 어떤 일정이 등록되었는지 보여줘야하기 때문에 print를 공통으로 사용한다.
	void print();
}

// 추상 클래스를 정의하여 공통으로 사용하는 필드 정의
public abstract class AbstractEvent implements Event {
	private int id;
	private String title;
	private ZonedDateTime startAt;
	private ZonedDateTime endAt;

	private boolean deletedYn;

	private ZonedDateTime createdAt;
	private ZonedDateTime modifiedAt;

	protected abstract void update(); // 각 세부 이벤트 타입에서 필요한 수정을 하기 위함
}

public class Meeting extends AbstractEvent {
	private String description;
	private set<String> participants;
}

public class Todo extends AbstractEvent {

}

public class OutOfOffice extends AbstractEvent {

}

public class NoDisturbance extends AbstractEvent {

}
```

여러 이벤트를 관리하는 객체는 Schedule

# CSV 읽기

- open-csv
- https://www.baeldung.com/
