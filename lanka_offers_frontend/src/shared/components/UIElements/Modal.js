import React from 'react';
import ReactDOM from 'react-dom';
import { CSSTransition } from 'react-transition-group';

import Backdrop from './Backdrop';
import './Modal.css';

const ModalOverlay = props => {

  
  const content = (
   
    <div id="myModal" class="modal">
      <div className="modal-content">
        <div className="modal-header">
          <span className="close" onClick={props.onCancel} >&times;</span>
          <h2>{props.header}</h2>
        </div>
        <form
        onSubmit={
          props.onSubmit ? props.onSubmit : event => event.preventDefault()
        }
      >
        <div className="modal-body">
        {props.children}
        </div>
        <div className={`modal-footer ${props.footerClass}`}>
          <h3>  {props.footer}</h3>
        </div>
        </form>
      </div>
    
    </div>
  );
  return ReactDOM.createPortal(content, document.getElementById('modal-hook'));
};

const Modal = props => {

  
  return (
    <React.Fragment>
      {props.show && <Backdrop onClick={props.onCancel} />}
      <CSSTransition
        in={props.show}
        mountOnEnter
        unmountOnExit
        timeout={200}
        classNames="modal"
      >
        <ModalOverlay {...props} />
      </CSSTransition>
    </React.Fragment>
  );
};

export default Modal;
