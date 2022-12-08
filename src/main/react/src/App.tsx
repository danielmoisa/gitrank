import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import {
  useQuery,
  gql
} from "@apollo/client";

const GET_GITHUB_REPOS = gql`
  query GetGithubRepos {
    repos {
    id
    name
    fullName
    repoHtmlUrl
    description
    stars
    language
  }
  }
`;

function App() {
  const { loading, error, data } = useQuery(GET_GITHUB_REPOS);


  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error :(</p>;


  return data?.repos?.map(({ id,
    name,
    fullName,
    repoHtmlUrl,
    description,
    stars,
    language, }) => (
    <div className='p-2 m-2 bg-gray-500 text-left' key={id}>
      <p>Repo name:{name}</p>
      <p>Full name: {fullName}</p>
      <p>Description: {description}</p>
      <p>Number of stars: {stars}</p>
      <p>Language: {language}</p>
      <p>Url: <a target="_blank" href={repoHtmlUrl}>{repoHtmlUrl}</a></p>
    </div>
  ));
}

export default App
