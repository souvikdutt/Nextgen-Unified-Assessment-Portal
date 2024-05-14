import React from "react";
import { Button } from "react-bootstrap";

class MenteesTable extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      mentees: [],
    };
  }
  render() {
    return (
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Emp ID</th>
            <th scope="col">Mentee Name</th>
            <th scope="col">Target Position</th>
            <th scope="col">Month for Mock</th>
            <th scope="col">Month for UA</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">4</th>
            <td>Souvik Dutta</td>
            <td>Software Engineer</td>
            <td>Jan</td>
            <td>Feb</td>
            <td>Active</td>
            <td>
              <Button variant="info">Edit</Button>
            </td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Prakhar Agarwal</td>
            <td>Software Engineer</td>
            <td>Feb</td>
            <td>Mar</td>
            <td>In-Progress</td>
            <td>
              <Button variant="info">Edit</Button>
            </td>
          </tr>
        </tbody>
      </table>
    );
  }
}

export default MenteesTable;
