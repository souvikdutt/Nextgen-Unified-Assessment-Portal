import { Button, Modal } from "react-bootstrap";
import React, { useState } from "react";
import axios from "axios";

export default function RequestForm(props) {
  const menteeData = {
    empId: "2",
    targetMonthForMockInterview: "",
    targetMonthForUA: "",
    status: "NEW",
    availableMockInterviewSlot: "",
    targetPosition: "",
  };

  const [show, setShow] = useState(false);
  const [buttonChanger, changer] = useState("+ Create Request");
  const [btnClassProperty, changeClassName] = useState(
    props.data.btnClassProperty
  );
  const [btnVisibility, changeVisibility] = useState(props.data.btnVisibility);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const onSubmit = (e) => {
    e.preventDefault();
    menteeData.targetPosition = e.target.targetPosition.value;
    menteeData.targetMonthForMockInterview =
      e.target.targetMonthForMockInterview.value;
    menteeData.targetMonthForUA = e.target.targetMonthForUA.value;

    axios
      .post("http://localhost:8008/mentees/register", menteeData)
      .then((response) => {
        console.log(response);
        setShow(false);
        changer("Requested");
        changeClassName("btn btn-danger btn-lg m-3");
        changeVisibility(true);
      });
  };

  return (
    <>
      <div className="mt-5">
        <Button
          variant="primary"
          onClick={handleShow}
          className={btnClassProperty}
          disabled={btnVisibility}
        >
          {buttonChanger}
        </Button>
      </div>
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Header closeButton>
          <Modal.Title>Create Request for UA</Modal.Title>
        </Modal.Header>
        <form onSubmit={onSubmit}>
          <Modal.Body>
            <div className="mb-3">
              <label htmlFor="selectedRole" className="form-label">
                Select Position for UA
              </label>
              <select
                id="selectedRole"
                name="targetPosition"
                className="form-select"
              >
                <option>Software Engineer (L2)</option>
                <option>Senior Software Engineer (L3)</option>
                <option>Lead Software Engineer (L4)</option>
              </select>
            </div>
            <div className="mb-3">
              <label htmlFor="selectedMockMonth" className="form-label">
                Select Target Month for Mock
              </label>
              <select
                id="selectedMockMonth"
                name="targetMonthForMockInterview"
                className="form-select"
              >
                <option>Jan</option>
                <option>Feb</option>
                <option>Mar</option>
                <option>Apr</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>Aug</option>
                <option>Sept</option>
                <option>Oct</option>
                <option>Nov</option>
                <option>Dec</option>
              </select>
            </div>
            <div className="mb-3">
              <label htmlFor="selectedMonth" className="form-label">
                Select Target Month for Interview
              </label>
              <select
                id="selectedMonth"
                name="targetMonthForUA"
                className="form-select"
              >
                <option>Jan</option>
                <option>Feb</option>
                <option>Mar</option>
                <option>Apr</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>Aug</option>
                <option>Sept</option>
                <option>Oct</option>
                <option>Nov</option>
                <option>Dec</option>
              </select>
            </div>
          </Modal.Body>
          <Modal.Footer>
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
          </Modal.Footer>
        </form>
      </Modal>
    </>
  );
}
