package com.ohgirap.section01.entity;

import javax.persistence.*;
import java.util.Date;



/*-회원 -
회원의 pk는 데이터베이스에서 관리하는 전략을 사용한다.
회원의 닉네임의 길이는 최대 10자이다.
회원의 닉네임은 중복되지 않는다.
회원의 전화번호의 기본값은 010-0000-0000이다.
권한은 enumType으로 관리한다.
등록일,수정일은 날짜및 시간이 모두 저장되며
삭제일은 날짜만 표기한다.
수정일 삭제일을 제외한 모든 컬럼은 null을 허용하지 않는다.
* */
@Entity(name = "member_section01_members")
@Table(name = "tbl_member_section01_members")

public class Member {

    @Id
    @Column(nullable = false)
    private int memberNum;                                //회원번호
    @Column(nullable = false)
    private String memberName;                        //이름

    @Column(name = "nickname", length = 10, unique = true , nullable = false)
    private String memberNickName;              //닉네임
    @Column(name = "phone" , columnDefinition = "varchar(200) default' 010-0000-0000' ", nullable = false)
    private String phone;                                   //전화번호
    @Column(nullable = false)
    private String PostalCode;                          //우편번호
    @Column(nullable = false)
    private String Address;                             //주소
    @Column(nullable = false)
    private String DetailedAddress;             //상세주소
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType MemberRole;                  //권한명(enum)
    @Column(nullable = false)
    private  String State;                              //상태
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date RegistrationDate;             //등록일
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ModifyDate;                      //수정일
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date DeleteDate;                        //삭제일


    //생성자

    public Member() {
    }

    public Member(int memberNum, String memberName, String memberNickName, String phone, String postalCode, String address, String detailedAddress, RoleType memberRole, String state, Date registrationDate, Date modifyDate, Date deleteDate) {
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.memberNickName = memberNickName;
        this.phone = phone;
        PostalCode = postalCode;
        Address = address;
        DetailedAddress = detailedAddress;
        MemberRole = memberRole;
        State = state;
        RegistrationDate = registrationDate;
        ModifyDate = modifyDate;
        DeleteDate = deleteDate;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDetailedAddress() {
        return DetailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        DetailedAddress = detailedAddress;
    }

    public RoleType getMemberRole() {
        return MemberRole;
    }

    public void setMemberRole(RoleType memberRole) {
        MemberRole = memberRole;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        ModifyDate = modifyDate;
    }

    public Date getDeleteDate() {
        return DeleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        DeleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNum=" + memberNum +
                ", memberName='" + memberName + '\'' +
                ", memberNickName='" + memberNickName + '\'' +
                ", phone='" + phone + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", Address='" + Address + '\'' +
                ", DetailedAddress='" + DetailedAddress + '\'' +
                ", MemberRole=" + MemberRole +
                ", State='" + State + '\'' +
                ", RegistrationDate=" + RegistrationDate +
                ", ModifyDate=" + ModifyDate +
                ", DeleteDate=" + DeleteDate +
                '}';
    }
}
