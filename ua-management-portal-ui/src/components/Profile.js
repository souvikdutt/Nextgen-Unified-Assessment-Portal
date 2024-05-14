import "../App.css";
import React from 'react';

class Profile extends React.Component {
  render() {
    return (
    <div className="container">
      <div className="profile-card">
        <header>
          <a href="#">
            <img src="http://victory-design.ru/sandbox/codepen/profile_card/avatar.svg" />
          </a>

          <h4>V. Garikipati</h4>
          <h6>Lead Software Engineer</h6>
        </header>
        <div className="profile-bio">
          <p>
            Even when everything is perfect, you can always make it better.
            Break barriers in your head, create something crazy and don't forget
            Code is Poetry...
          </p>
        </div>
      </div>
    </div>
    );
  }
}

export default Profile;
