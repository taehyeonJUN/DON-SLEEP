--釉뚮씪�슦�� 二쇱냼李쎌뿉 寃��깋�븯硫�
--http://localhost:7999/exweb/member/list.do

-- �쉶�썝 �젙蹂�(member) ���옣�쓣 �쐞�븳 �뀒�씠釉� �깮�꽦
--�쉶�썝 �븘�씠�뵒 mem_id 臾몄옄�뿴 (理쒕� 50諛붿씠�듃)
--�쉶�썝 鍮꾨�踰덊샇 mem_pass 臾몄옄�뿴 (理쒕� 50諛붿씠�듃)
--�쉶�썝 �씠由� mem_name 臾몄옄�뿴 (理쒕� 50諛붿씠�듃)
--�쉶�썝 point mem_point �닽�옄 (�젙�닔 理쒕� 10�옄由�)
create table member (
mem_id VARCHAR2(50),
mem_pass VARCHAR2(50),
mem_name VARCHAR2(50),
mem_point NUMBER(10,0),
PRIMARY KEY (mem_id)
);

INSERT into MEMBER
(mem_id, mem_pass, mem_name, mem_point)
values 
('a001', '1234', '�솉湲몃룞', 100);

commit;

SELECT * FROM MEMBER;

SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER;

UPDATE member SET MEM_POINT = 7 where mem_id='a001';
commit;
SELECT * FROM member;
DELETE  FROM MEMBER WHERE mem_id='a003';

INSERT into MEMBER
(mem_id, mem_pass, mem_name, mem_point)
values 
('a003', '1234', '留덇만�룞', 100);

create table student (
stu_no VARCHAR2(50),--�븰踰�
stu_name VARCHAR2(50),--�씠由�
stu_score NUMBER(10,0),--�꽦�쟻
PRIMARY KEY (stu_no)
);

--게시판
create table bbs(
bbs_no number(10,0), -- 글번호
bbs_writer varchar2(50), -- 작성자 아이디
bbs_title varchar2(100), -- 글제목
bbs_content clob, --clob -대용량의 문자 내용 저장 가능, dlob는 이미지 영상등
bbs_reg_date date default SYSDATE, --글 등록일(작성일)
bbs_count number(10,0) default 0, --조회수
--최종 수정일, 작성자 IP주소 ....etc
PRIMARY KEY(bbs_no), foreign key (bbs_writer) REFERENCES member(mem_id)
); --두개이상의 첨부파일은 다른 테이블로 작성해야 함

insert into bbs(bbs_no,bbs_title,bbs_content, bbs_writer)
values(seq_bbs_no.NEXTVAL,'테스트제목','테스트내용','a001');

SELECT * FROM bbs;

--시퀀스 (게시판 글번호를 위한 자동 증가 정수값 생성)
create SEQUENCE seq_bbs_no;


select seq_bbs_no.NEXTVAL from DUAL; --시퀀스의 다음값(증가된 값) 가져오기
select seq_bbs_no.CURRTVAL from DUAL; --시퀀스의 현재값 가져오기











--게시판 첨부파일 테이블
create table attach (
att_no NUMBER(10,0) PRIMARY KEY, --첨부파일 번호
att_org_name VARCHAR2(255), --첨부파일의 원래 파일명
att_new_name VARCHAR2(255), --서버에 저장한 파일명
att_bbs_no Number(10,0), --첨부파일이 속한 게시글의 글 번호
foreign key(att_bbs_no)references bbs(bbs_no)
);

SELECT * FROM attach;


create SEQUENCE seq_att_no;

select seq_att_no.NEXTVAL from DUAL;

commit;



SELECT bbs_no, bbs_title, bbs_content, bbs_writer, bbs_reg_date, bbs_count,
att_no,att_org_name,att_new_name,att_bbs_no
FROM bbs LEFT OUTER join ATTACH on bbs_no=att_bbs_no
where bbs_no=70;








