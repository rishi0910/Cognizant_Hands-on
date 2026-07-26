import React, { Component } from 'react';

class ComplaintRegistration extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: ''
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    this.setState({
      [e.target.name]: e.target.value
    });
  }

  handleSubmit(e) {
    e.preventDefault();
    const refNo = Math.floor(20000 + Math.random() * 70000);
    alert('Thanks ' + this.state.ename + '\n Complaint was submitted.\nReference No: ' + refNo);
  }

  render() {
    return (
      <div style={{ width: '300px', margin: '25px auto', padding: '25px', border: '1px solid #ddd' }}>
        <h2 style={{ textAlign: 'center' }}>Register Complaint</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '12px' }}>
            <label>Employee Name:</label>
            <br />
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
              style={{ width: '100%', marginTop: '5px', padding: '6px' }}
            />
          </div>

          <div style={{ marginBottom: '12px' }}>
            <label>Complaint:</label>
            <br />
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              rows="4"
              required
              style={{ width: '100%', marginTop: '5px', padding: '6px' }}
            />
          </div>

          <button type="submit" style={{ padding: '6px 12px' }}>
            Submit Complaint
          </button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegistration;