@Service
public class TableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getTableData(String tableName) {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

	public List<Map<String, Object>> getTableNames() {
		 return jdbcTemplate.queryForList("SHOW TABLES");
	}
}
