import React from "react";
import TabsForHR from './TabsForHR'

class HR extends React.Component {
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
            <h3>Welcome HR!</h3>
          </div>
          <TabsForHR data={this.state} />
        </div>
      </div>
    );
  }
}

export default HR;
