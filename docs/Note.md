~~- Staff
  - ~~int order~~
  - Name name
  - boolean isHoilday
- WeekdayStaffs - List<Staff> :
- HolidayStaffs - List<Staff>

- day : month, day,dayOfWeek, isWeekend, isHoliday, Staff
- days : List<Day> = ScheduleRepository impl days
  - setMonth
  - setDay
  - setDayOfWeek
  - setIsWeekEnd
  - setIsHoliday
  - SetStaff

- WeekdayParser - String으로 들어오면 for로 돌려서 i값을 order로해서 WeekdayStaffs생성
- HolidayParser

- OnCallService -  impl -WeekdayStaffs,HolidayStaffs,ScheduleRepository
- OnCallPrinter~~

#### Enum
- Holiday
- 각 달에 몇개의 일이 있는지


### 플로우
#### 요일 등록
- 달 + 요일을 입력받아서 days에 넘기기
- day에 등록
- 생성자에서 List<day> 바로 만들기 - MonthDayListMaker
  - MonthDays에서 for i해서 List<Integer> 생성 - day필드
  - List<Integer> Weekday에 넘겨서 List<String> 만들어오기 - dayofweek업데이트
  - Holliday확인  - isHoilday 업데이트

#### 주말, 평일 staff 등록
- Parser에서 받아서 데이터를 List<Staff>로 파싱 후 Staffs 데이터 생성함 + 유효 검사 : 
  - Name 객체에서 이름 유효검사
  - Parser에서 Staffs생성자로 넘기기 전에 인원수 유효검사 
  - 닉네임 중복 검사

#### 리스트 만들기 OnCallService return 스캐줄
- Staffs isHoilday & dayisHoilday가 같으면 - day에 Staff를 추가
- while 중복되지 않을때까지
- 만약 중복되면 day[i+1]과 day[i+2]의 Staff 필드를 바꿈
- 

#### printer출력
- for Days 돌린다음에 OnCallListFormatter로 String포맷 받아서 하나한 출력하기


---
- 구분짓지말고 다 만들어두고 필드 order값만 변경하면 될 거 같다.
- 만약 days의 isHoliwood가 true일 경우 (휴일) 추가 출력 =- 양식 넣어야됨
- (휴일)을 붙여야하는 경우 isHoliday
  - isWeekday +
  - hoilday에 month+day를 넘겼을때 true일 경우