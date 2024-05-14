import React from "react";
import { Button } from "react-bootstrap";
import axios from "axios";
import { fetchAllMentors } from "../api/api";

class Table extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      mentors: [],
    };
  }

  menteeData = {
    menteeId: "2",
    mentorId: "",
  };

  sendRequestToMentor = (mentorId) => {
    this.menteeData.mentorId = mentorId;

    // axios.post("", this.menteeData).then((response) => {
    //   console.log(response);
    // });
  };

  componentDidMount() {
    // axios.get('http://localhost:8080/mentor/available')
    fetchAllMentors().then((response) => {
      this.setState({
        mentors: response.data
      });
    });
  }

  render() {
    const { mentors } = this.state;
    return (
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Emp ID</th>
            <th scope="col">Mentor Name</th>
            <th scope="col">Email</th>
            <th scope="col">Slot Availability</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {mentors
            .filter((mentor) => mentor.isAvailable === "Y")
            .map((mentor, i) => {
              return (
                <tr key={mentor.empId}>
                  <th scope="row">{mentor.empId}</th>
                  <td>{mentor.name}</td>
                  <td>{mentor.email}</td>
                  <td>{mentor.availableMenteesSlot}</td>
                  <td>
                    <Button
                      onClick={() => this.sendRequestToMentor(mentor.empId)}
                      variant="info"
                    >
                      Request
                    </Button>
                  </td>
                </tr>
              );
            })}
        </tbody>
      </table>
    );
  }
}

export default Table;
