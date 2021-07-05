import React, { useState, useContext } from "react";
import "../../../assets/w3.css";
import Modal from "../UIElements/Modal";
import "./TopNav.css";
import Input from "../FormElements/Input";
import {
  VALIDATOR_REQUIRE,
  VALIDATOR_MINLENGTH,
} from "../../../shared/util/validators";
import Button from "../FormElements/Button";
import { useForm } from "../../hooks/form-hook";
import { AuthContext } from "../../../shared/context/auth-context";

const TopNav = (props) => {
  const [showLogin, setShowLogin] = useState(false); // modal
  const [isLoginMode, setIsLoginMode] = useState(true); //login signin
  const auth = useContext(AuthContext); // authentication hooks
  const openLoginHandler = () => setShowLogin(true);

  const closeLoginHandler = () => setShowLogin(false);

  const [formState, inputHandler, setFormData] = useForm(
    {
      email: {
        value: "",
        isValid: false,
      },
      password: {
        value: "",
        isValid: false,
      },
    },
    false
  );

  const switchModeHandler = () => {
    if (!isLoginMode) {
      setFormData(
        {
          ...formState.inputs,
          name: undefined,
        },
        formState.inputs.email.isValid && formState.inputs.password.isValid
      );
    } else {
      setFormData(
        {
          ...formState.inputs,
          name: {
            value: "",
            isValid: false,
          },
        },
        false
      );
    }
    setIsLoginMode((prevMode) => !prevMode);
  };

  const logInSubmitHandler = (event) => {
    event.preventDefault();
    console.log(formState.inputs); // send this to backend
    auth.login();
  };

  const openLogOutHandler = (event) => {
    event.preventDefault();
    auth.logout();
  }

  return (
    <React.Fragment>
      <Modal
        show={showLogin}
        onCancel={closeLoginHandler}
        contentClass="place-item__modal-content"
        footerClass="place-item__modal-actions"
        footer={
          <button className="buttonh " onClick={closeLoginHandler}>
            Close
          </button>
        }
      >
        <div className="container">
          <div class="login-form">
            <form onSubmit={logInSubmitHandler}>
              <h2>
                {" "}
                <a>
                  {" "}
                  <i
                    className="fa fa-play-circle-o"
                    style={{ fontSize: "38px", color: "rgb(128, 240, 118)" }}
                  />
                </a>{" "}
                Login
              </h2>
              {!isLoginMode && (
                <Input
                  element="input"
                  id="name"
                  type="text"
                  placeholder="your name"
                  validators={[VALIDATOR_REQUIRE()]}
                  errorText="Please enter a name."
                  onInput={inputHandler}
                />
              )}
              <Input
                id="email"
                element="input"
                type="email"
                placeholder="Username or email"
                errorText="Please Enter valid email"
                validators={[VALIDATOR_REQUIRE()]}
                onInput={inputHandler}
              />
              {/* <input
                type="email"
                placeholder="Username or email id"
                name="username"
                required
              /> */}
              <Input
                id="password"
                element="input"
                type="password"
                placeholder="Enter password"
                errorText="Please Enter valid password"
                validators={[VALIDATOR_REQUIRE()]}
                onInput={inputHandler}
              />
              <Button type="submit" disabled={!formState.isValid}>
                <i className="fa fa-unlock-alt"></i> &nbsp;{" "}
                {isLoginMode ? "LOGIN" : "SIGNUP"}
              </Button>

              <label className="remember-me">
                <input type="checkbox" name="remember" />
                Remember me
              </label>
              <span className="forget-psw">
                Forgot <a href="#">password?</a>
              </span>
              {isLoginMode && (
                <div className="social-btn">
                  <button type="submit" className="twitter-btn">
                    <i class="fa fa-google" aria-hidden="true"></i> Login with
                    Google
                  </button>
                  <button type="submit" className="facebook-btn">
                    <i class="fa fa-facebook" aria-hidden="true"></i> Login with
                    Facebook
                  </button>
                </div>
              )}
              <span className="signup">
                {isLoginMode
                  ? " Dont Have An Account? SignUp "
                  : " Already Have An Account? LogIn "}
                <a className="link" href="#" onClick={switchModeHandler}>
                  HERE
                </a>
              </span>
            </form>
          </div>
        </div>
      </Modal>

      <div className="w3-row topnav w3-center">
        {auth.isLoggedIn && (
          <a href="#home"  onClick={openLogOutHandler}>
            <i
              className="fa fa-compass"
              style={{ fontSize: "16px", color: "#ffffff" }}
            />{" "}
            LogOut
          </a>
        )}
        {!auth.isLoggedIn && (
          <a href="#home" onClick={openLoginHandler}>
            <i
              className="fa fa-compass"
              style={{ fontSize: "16px", color: "#ffffff" }}
            />{" "}
            Sign In / Register
          </a>
        )}

        <div className="vl hidden"></div>

        <a href="#contact">
          <i
            className="fa fa-mobile-phone"
            style={{ fontSize: "16px", color: "#ffffff" }}
          />
          &nbsp; Contact
        </a>
        
       
      </div>
    </React.Fragment>
  );
};

export default TopNav;
