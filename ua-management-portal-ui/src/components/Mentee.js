import React from "react";
import RequestForm from "./RequestForm";
import TabsForMentee from './TabsForMentee';

class Mentee extends React.Component {
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
            <div className="col-3 text-center mt-5">
                <h3>Welcome Mentee!</h3>
            </div>
            <TabsForMentee data={this.state}/>
        </div>
        
      </div>
    );
  }
}

export default Mentee;
