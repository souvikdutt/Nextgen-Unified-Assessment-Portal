import React from "react";
import Profile from "./Profile";
import TabsForMentor from './TabsForMentor'

class Mentor extends React.Component {
  constructor(props) {
    super(props);
    if (true) {
      this.state = {
        requested: false,
        btnVisibility: false,
        btnClassProperty: "btn btn-primary btn-lg",
      };
    }
  }
  render() {
    return (
      <div className="container-fluid text-center">
        <div className="row">
          <div className="col-3 text-center">
            <Profile/>
          </div>
          <TabsForMentor data={this.state} />
        </div>
      </div>
    );
  }
}

export default Mentor;
