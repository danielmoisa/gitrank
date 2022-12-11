import './App.css'
import {
  useQuery,
  gql
} from "@apollo/client";
import { useMemo } from 'react';
import Table from './components/Table';
import { Column } from 'react-table';

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

  const columns = useMemo(
    () => [
      {
        Header: 'Score',
        accessor: 'score'
      },
      {
        Header: 'Name',
        accessor: 'fullName',
      },
      {
        Header: 'Stars',
        accessor: 'stars',
      },
      {
        Header: 'Language',
        accessor: 'language',
      },
      {
        Header: 'Name',
        accessor: 'name',
      },
      {
        Header: 'Url',
        accessor: 'repoHtmlUrl',
      },
    ],
    []
  )


  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error :(</p>;

  return <div>
    <Table columns={columns} data={data?.reposByScore} />
  </div>

}

export default App
