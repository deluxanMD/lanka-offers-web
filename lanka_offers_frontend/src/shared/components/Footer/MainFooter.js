import React, { Component } from "react";
import Footer from "./Footer";
import FooterTop from "./FooterTop";
import FooterBottom from "./FooterBottom";


const MainFooter = () => {
  return (
      <React.Fragment>
          <Footer>
              <FooterTop/>
              <FooterBottom/>
              
          </Footer>
      </React.Fragment>

  );
};

export default MainFooter;
