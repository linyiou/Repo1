package domain;

//�ÿ�
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType; //֤������ 0���֤ 1���� 2����֤
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType; //�ÿ�����(��Ⱥ) 0 ���� 1 ��ͯ
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //֤������ 0���֤ 1���� 2����֤
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "���֤";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "����";
            } else if (credentialsType == 2) {
                credentialsTypeStr = "����֤";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        ////�ÿ�����(��Ⱥ) 0 ���� 1 ��ͯ
        if (travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr = "����";
            } else if (travellerType == 1) {
                travellerTypeStr = "��ͯ";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
