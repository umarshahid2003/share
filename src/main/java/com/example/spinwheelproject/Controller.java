package com.example.spinwheelproject;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class Controller {
    @FXML
    private Button play;
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Button signUpBtn;

    @FXML
    private ArrayList<UserLoginIn> userLoginIns;
    @FXML
    private ArrayList<UserSignUp> userSignUps = new ArrayList<UserSignUp>();

    private void setUserSignUps() throws IOException, ClassNotFoundException {
        File file = new File("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin");
        try (FileInputStream fis = new FileInputStream(file)) {
            ObjectInputStream is = new ObjectInputStream(fis);
            if (file.isFile()) {
                this.userSignUps = (ArrayList<UserSignUp>)is.readObject();
            }
        }


        try (FileOutputStream fos = new FileOutputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin")) {
            ObjectOutputStream os = new ObjectOutputStream(fos);
            UserSignUp userSignUp = new UserSignUp(signUpUsername.getText(), signUpPassword.getText(), signUpConfirmPassword.getText(), birthPlace.getText(), favouriteTeacher.getText());
            userSignUps.add(userSignUp);
            os.writeObject(userSignUps);
            System.out.println(userSignUps);
//            try (FileInputStream fis = new FileInputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin")) {
//                ObjectInputStream is = new ObjectInputStream(fis);
//                Object obj;
//                int i = 0;
//                while (!((obj = is.readObject()) instanceof Endoffile)) {
//                    userSignUps.add(userSignUps.size(), (UserSignUp) obj);
//                    System.out.println(userSignUps.get(i).favouriteTeacher);
//                    i++;
//                }
//                if (i == 0) {
//                    try(FileOutputStream fos1 = new FileOutputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin")){
//
//                    }
//                }
//            }
//            userSignUps.add(userSignUp);
        }
    }

    @FXML
    private Button signInBtn;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private void loginData() throws IOException, ClassNotFoundException {

        for (int i = 0; i < userSignUps.size()-1; i++) {
            if (Objects.equals(loginUsername.getText(), userSignUps.get(i).signUpUsername) && (Objects.equals(loginPassword.getText(), userSignUps.get(i).signUpPassword))){
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Forgot-pass.fxml")));
                Stage LoginWindow = (Stage) forgotPassword.getScene().getWindow();
                LoginWindow.setScene(new Scene(root));
            }
        }

//        try (FileOutputStream fos = new FileOutputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\login.bin")) {
//            ObjectOutputStream os = new ObjectOutputStream(fos);
//            UserLoginIn user = new UserLoginIn();
//            user.username = loginUsername.getText();
//            user.password = loginPassword.getText();
//            os.writeObject(user);
//        }

    }

    @FXML
    private void play(ActionEvent event) throws IOException, InterruptedException {
        setRotate(c1, 360, 3);
        setRotate(c2, 180, 5);
        newWindow();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
//        Stage LoginWindow = (Stage) play.getScene().getWindow();
//        LoginWindow.setScene(new Scene(root));
    }

    private void setRotate(Circle c, int angle, int duration) throws IOException, InterruptedException {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(false);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(5);
        rt.setCycleCount(100);
        rt.play();

    }

    private void newWindow() throws IOException, InterruptedException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        stage.show();
    }

    //Sign Up


    @FXML
    private PasswordField birthPlace;

    @FXML
    private PasswordField favouriteTeacher;

    @FXML
    private PasswordField signUpConfirmPassword;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpUsername;

    @FXML
    private void SignUpData() throws IOException, ClassNotFoundException {
        setUserSignUps();
//        try (FileOutputStream fos = new FileOutputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin",true)) {
//            ObjectOutputStream os = new ObjectOutputStream(fos);
//            try (FileInputStream fis = new FileInputStream("E:\\OOP\\JAVA FX\\SpinWheelProject\\src\\main\\resources\\File\\SignUp.bin")) {
//            ObjectInputStream is = new ObjectInputStream(fis);
//            this.userSignUps = (ArrayList<UserSignUp>) is.readObject();
//            Object obj;
//            int i = 0;
//            while (!((obj = is.readObject()) instanceof EndOfFile)) {
//                    userSignUps.add(userSignUps.size(), (UserSignUp) obj);
//                    System.out.println(userSignUps.get(i).favouriteTeacher);
//                    i++;
//            }
//            UserSignUp userSignUpInfo;
//            userSignUpInfo = (UserSignUp) is.readObject();
//            userSignUpInfo.signUpUsername = signUpUsername.getText();
//            userSignUpInfo.signUpPassword = signUpPassword.getText();
//            userSignUpInfo.signUpConfirmPassword = signUpConfirmPassword.getText();
//            userSignUpInfo.favouriteTeacher = favouriteTeacher.getText();
//            userSignUpInfo.birthPlace = birthPlace.getText();
////            System.out.println(userSignUpInfo.favouriteTeacher);
        }



    @FXML
    private AnchorPane myCircle;
    @FXML
    private Button spinWheel;
    double x = 0;

    //Loading Page

    @FXML
    private Text SignUptext;

    @FXML
    private void SignupTologin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sign-up.fxml")));
        Stage stage = (Stage) forgotPassword.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    private Text forgotPassword;
    @FXML
    private void loginToForgotPassword(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Forgot-pass.fxml")));
        Stage LoginWindow = (Stage) forgotPassword.getScene().getWindow();
        LoginWindow.setScene(new Scene(root));
    }

    @FXML
    private Text SigninText;
    @FXML
    private Button SignupBtn;

    @FXML
    private void SignuptoSignin(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage LoginWindow = (Stage) SigninText.getScene().getWindow();
        LoginWindow.setScene(new Scene(root));
    }
    @FXML
    void rotate(MouseEvent event) {
        for (int i = 0; i < 60; i++) {
            myCircle.setRotate(i);
        }
    }




//    @FXML
//    private Text SignUp;

//    @FXML
//    private void logintoSignUp(MouseEvent event) throws Exception{
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
//        Stage LoginWindow = (Stage) SignUp.getScene().getWindow();
//        LoginWindow.setScene(new Scene(root));
//    }




    //LoginWindow Opening



//    @FXML
//    private Button signUpBtn,loginBtn,playBtnLoading;
//    public void SignUpBtn() throws Exception{
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
//        Stage LoginWindow = (Stage) signUpBtn.getScene().getWindow();
//        LoginWindow.setScene(new Scene(root));
//    }
//    public void LoginBtn() throws Exception{
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
//        Stage SignupWindow = (Stage) loginBtn.getScene().getWindow();
//        SignupWindow.setScene(new Scene(root));
//
//    }
//    public void playBtnLoading() throws Exception{
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
//        Stage SignupWindow = (Stage) playBtnLoading.getScene().getWindow();
//        SignupWindow.setScene(new Scene(root));
//
//    }



    //DashBoard


    @FXML
    private ImageView home;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView setting;

    @FXML
    private void dashBordToSetting() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Settings.fxml")));
        Stage LoginWindow = (Stage) setting.getScene().getWindow();
        LoginWindow.setScene(new Scene(root));
    }


    //Settings
    @FXML
    private ImageView SettingBack;

    @FXML
    private void SettingToDashBoard() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard_farhaal.fxml")));
        Stage LoginWindow = (Stage) SettingBack.getScene().getWindow();
        LoginWindow.setScene(new Scene(root));
    }

}