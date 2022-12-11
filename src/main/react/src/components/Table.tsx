import { useTable, usePagination, Column, Row } from 'react-table'

interface TableProps<T extends object> {
    columns: { Header: string, accessor: string }[];
    data: T[];
}

function Table<T extends { id: string }>({ columns, data }: TableProps<T>) {
    // Use the state and functions returned from useTable to build your UI
    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        prepareRow,
        //@ts-ignore
        page, canPreviousPage, canNextPage, pageOptions, pageCount, gotoPage, nextPage, previousPage, setPageSize, state: { pageIndex, pageSize },
    } = useTable<T>(
        {
            //@ts-ignore
            columns,
            data,
            //@ts-ignore
            initialState: { pageIndex: 2 },
        },
        usePagination
    )

    // Render the UI for your table
    return (
        <>

            <table className='bg-[#3B44F6] rounded-md text-left text-[14px] my-6' {...getTableProps()}>
                <thead>
                    {headerGroups.map(headerGroup => (
                        <tr {...headerGroup.getHeaderGroupProps()}>
                            {headerGroup.headers.map(column => (
                                <th className='px-3 py-1' {...column.getHeaderProps()}>{column.render('Header')}</th>
                            ))}
                        </tr>
                    ))}
                </thead>
                <tbody {...getTableBodyProps()}>
                    {page.map((row: Row<T>) => {
                        prepareRow(row)
                        return (
                            <tr className='' {...row.getRowProps()}>
                                {row.cells.map(cell => {
                                    console.log(cell)
                                    return <td className='p-3 border border-gray-400' {...cell.getCellProps()}>
                                        <a className='text-white' href={cell.row.values.repoHtmlUrl} target="_blank">
                                            {cell.render('Cell')}
                                        </a></td>
                                })}
                            </tr>
                        )
                    })}
                </tbody>
            </table>
            {/* 
        Pagination can be built however you'd like. 
        This is just a very basic UI implementation:
      */}
            <div className="pagination">
                <button onClick={() => gotoPage(0)} disabled={!canPreviousPage}>
                    {'<<'}
                </button>{' '}
                <button onClick={() => previousPage()} disabled={!canPreviousPage}>
                    {'<'}
                </button>{' '}
                <button onClick={() => nextPage()} disabled={!canNextPage}>
                    {'>'}
                </button>{' '}
                <button onClick={() => gotoPage(pageCount - 1)} disabled={!canNextPage}>
                    {'>>'}
                </button>{' '}
                <span>
                    Page{' '}
                    <strong>
                        {pageIndex + 1} of {pageOptions.length}
                    </strong>{' '}
                </span>
                <span>
                    | Go to page:{' '}
                    <input
                        type="number"
                        defaultValue={pageIndex + 1}
                        onChange={e => {
                            const page = e.target.value ? Number(e.target.value) - 1 : 0
                            gotoPage(page)
                        }}
                        style={{ width: '100px' }}
                    />
                </span>{' '}
                <select
                    value={pageSize}
                    onChange={e => {
                        setPageSize(Number(e.target.value))
                    }}
                >
                    {[10, 20, 30, 40, 50].map(pageSize => (
                        <option key={pageSize} value={pageSize}>
                            Show {pageSize}
                        </option>
                    ))}
                </select>
            </div>
        </>
    )
}

export default Table