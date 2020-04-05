import React from 'react';
import logo from './logo.svg';
import './App.css';

class App extends React.Component {

  state = { url: '', shortenedUrl: '' }


  handleChange = (event) => {
    this.setState({ url: event.target.value });
  }

  handleSubmit = (event) => {
    this.setState({
      shortenedUrl: ''
    })
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.state.url)
    };
    fetch('http://localhost:8080/shorten', requestOptions)
      .then(response => response.json())
      .then(data => this.setState({ shortenedUrl: data.shortenedUrl }));
    event.preventDefault();
  }

  render() {
    const { shortenedUrl, url } = this.state;
    return (
      <div className="App">
        <main>
          <form onSubmit={this.handleSubmit}>
            <label>
              Name:
              <input type="text" value={url} onChange={this.handleChange} />
            </label>
            <input type="submit" value="Submit" />
          </form>
          <p>

            {shortenedUrl && <a href={`http://localhost:8080/redirect/${shortenedUrl}`}>http://localhost:8080/redirect/{shortenedUrl}</a>}
          </p>
        </main>
      </div>
    );
  }
}
export default App;
