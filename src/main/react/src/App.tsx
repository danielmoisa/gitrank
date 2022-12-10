import './App.css'
import {
  useQuery,
  gql
} from "@apollo/client";

type Repo = {
  id: number
  name: string
  fullName: string
  repoHtmlUrl: string
  description: string
  stars: number
  language: string
  score: number
}

const GET_REPOS_BY_SCORE = gql`
  query GetReposByScore {
    reposByScore {
    id
    name
    fullName
    repoHtmlUrl
    description
    stars
    language
    score
  }
  }
`;

function App() {
  const { loading, error, data } = useQuery(GET_REPOS_BY_SCORE);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error :(</p>;

  return data?.reposByScore?.map(({ id,
    name,
    fullName,
    repoHtmlUrl,
    description,
    stars,
    language, score }: Repo) => (
    <div className='p-2 m-2 bg-gray-500 text-left' key={id}>
      <p>Repo name:{name}</p>
      <p>Full name: {fullName}</p>
      <p>Description: {description}</p>
      <p>Number of stars: {stars}</p>
      <p>Language: {language}</p>
      <p>Url: <a target="_blank" href={repoHtmlUrl}>{repoHtmlUrl}</a></p>
      <p>Score: {score}</p>
    </div>
  ));
}

export default App
