package com.jd.clonestudy;

import java.io.*;

public class Company implements Cloneable, Serializable {
    private User user;

    private String address;

    public Company(User user, String address) {
        super();
        this.user = user;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
    protected Object deppClone() throws IOException, ClassNotFoundException, OptionalDataException {
        // 将对象写入流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        // 将对象从流中读出
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        return ois.readObject();


//        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        Company company = (Company) obj;
        if (user.equals(company.getUser()) && address.equals(company.address)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, OptionalDataException{
        Company companyOne, companyTwo, companyThree;
        companyOne = new Company(new User("username", "password"), "上海市");
        companyTwo = companyOne;
        companyThree = (Company) companyOne.deppClone();

        System.out.println(companyTwo==companyOne);                //true
        System.out.println(companyTwo.equals(companyOne));        //true

        System.out.println(companyThree==companyOne);            //false
        System.out.println(companyThree.equals(companyOne));    //true

        System.out.println(companyThree.getUser()==companyOne.getUser());            //true ? 这里为什么不是false呢
        System.out.println(companyThree.getUser().equals(companyOne.getUser()));    //true

    }

}
