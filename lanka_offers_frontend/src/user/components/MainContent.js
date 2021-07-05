import React from "react";
import styled from "styled-components";
import './MainContent.css';


const Content = styled.div`
  background-color: #eeeeee;
  margin-left: 5%;
  margin-right: 5%;
  align-items: center;
  font-family: "Rubik";

  @media (max-width: 1000px) {
    margin-left: 0;
    margin-right: 0;
  }
`;

const MainContent = (props) => {
  return (
    <Content>
      <div className="spacer"></div>
      {props.children}
      &nbsp;
    </Content>
  );
};

export default MainContent;
