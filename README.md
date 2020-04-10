# java-chicken-2019

## 기능 요구사항
- 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.   
    - 주문등록, 결제하기, 프로그램 종료 기능을 가진다.
- 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가진다.
- 테이블 기본 정보가 주어지며 테이블 번호를 가진다.
- 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개이다.
- 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시한다.
- 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 달라진다.
    - 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
        - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
    - 현금 결제는 5%가 할인되며 할인된 금액에서 한 번 더 할인이 가능하다.
- 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다. 
- 최종 결제 금액을 보여준다.


## 프로그래밍 요구사항
- src/main/java/Application의 main()을 실행해 프로그램을 시작한다. 
- Application의 main()에서 구현을 시작한다.
- 주어진 Menu 클래스를 활용해 구현해야 한다. 
- Menu에 기본 생성자를 추가할 수 없다. 
- Menu의 필드(인스턴스 변수)를 추가할 수 없다.
    - 단, 기존 필드(인스턴스 변수)의 데이터 타입은 변경할 수 있다. 
- 필드(인스턴스 변수)의 접근 제어자는 private으로 구현해야 한다.

- MenuRepository 클래스를 활용해 구현해야 한다. 
- 데이터를 조회하는 DB 역할을 한다. 
- MenuRepository의 기존 코드는 수정할 수 없다.
    - 단, 추가는 가능하다.
    
- Table 클래스를 활용해 구현해야 한다.
- Table에 기본 생성자를 추가할 수 없다.
- 필드(인스턴스 변수)의 접근 제어자는 private으로 구현해야 한다.

- 위의 TableRepository 클래스를 활용해 구현해야 한다. 
- 데이터를 조회하는 DB 역할을 한다. 
- TableRepository의 기존 코드는 수정할 수 없다.
    - 단, 추가는 가능하다.
    
    
## 기능 구현 목록
- [ ] 메인화면
    - [ ] 1 주문하기 2 결제하기 3 프로그램 종료
    - [ ] 세가지 옵션 외 번호 입력시 예외 발생
- [ ] 테이블 목록
    - [ ] 주문 중인 테이블에 표식 남기기
- [ ] 테이블 선택
    - [ ] 테이블 번호 입력으로 선택
    - [x] 목록에 존재하지 않는 테이블 번호 입력 시 예외처리
- [ ] 메뉴 선택
    - [ ] 메뉴 번호로 메뉴 선택
    - [x] 목록에 존재하지 않는 메뉴 번호 입력 시 예외처리
- [ ] 수량 입력
    - [ ] 최소 수량 1 최대 수량 99
    - [ ] 같은 메뉴 추가 주문 시, 수량 만 증가
    - [ ] 추가 주문 일 때도 합산된 수량이 99를 넘어설 수 없음.
- [ ] 결제하기
    - [ ] 주문이 등록된 테이블 만 선택 가능
    - [ ] 주문내역 출력
    - [ ] 결제 수단 선택 1 신용카드, 2 현금력
    - [ ] 현금일 경우 5%할인
- [ ] 가격 계산 
    - [ ] 치킨 종류 10개 단위로 10,000원 씩 할인
    - [ ] 현금일 경우 5% 추가 할인
    - [ ] 최종 금액 계산
