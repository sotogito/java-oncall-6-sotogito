1. List<Day> 생성
   1. Day-days(레퍼지토리)
   2. MonthDayOfWeekParser 
   3. MonthDayListMaker - Days에서 제대로된 List<Day> 만들기
2. Staff 데이터 생성
   1. ~~Name 객체~~
   2. ~~Staff 객체 - name, isholiday~~
   3. ~~WeekdayStaffs, WeekdayParser~~
   4. H~~olidayStaffs,HolidayParse~~r
   5. ~~유효검사~~
3. List<Day>에 Staff 데이터 추가
   1. for days 돌려서 isWeekend, isholiwood 확인


### 주요 기능
- 평일-휴일or 평일-휴일 순번에 중복된 경우 주말 중복을 다음 순서와 변경한다. - 그냥 1열로 줄세운다음에 줄복 확인후 중복되면 바꾸면 됨
- 휴일은 - 주말 + 지정된 공휴일이다.
- Holiday인 경우 뒤에 (휴일)을 붙여야한다.
- 월 데이터를 가지고 일을 뽑아내는데 요일을 고려해서...
- 



### 유효 검사
- 평일, 주말 순번 닉네임 
  - 닉네임 중복
  - 1~5자
  - 인원 5~35
  
- 온콜
  - 연속 2일 근무 
    - 평일-주말은 어차피 중복으로 받을 수 없어 상관 없음, 평일->주말or 주말->평일로 넘어갈때 중복 확인
    - /> > 그냥 for하면서 통합으로 확인해도 될듯

### 주요
- 2월은 28일만 있음