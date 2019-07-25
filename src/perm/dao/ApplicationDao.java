package perm.dao;

import perm.model.Application;

/**
 * 
 * 
CREATE TABLE Application (
CaseNumber VARCHAR(255),
DecistionDate DATE,
CaseStatus ENUM('Denied', 'Certified-Expired', 'Certified'),
CaseReceivedDate DATE,
Refile BOOLEAN,
OriginalFileDate DATE,
Scheduled BOOLEAN,
EmployerName VARCHAR(255),
ApplicantID BIGINT,
AgentFirmName VARCHAR(255),
CONSTRAINT pk_Application_CaseNumber PRIMARY KEY (CaseNumber),
CONSTRAINT fk_Application_EmployerName FOREIGN KEY (EmployerName)
REFERENCES Employer (EmployerName)
ON UPDATE CASCADE ON DELETE SET NULL,
CONSTRAINT fk_Application_ApplicantId FOREIGN KEY (ApplicantID)
REFERENCES Applicants (ApplicantID)
ON UPDATE CASCADE ON DELETE SET NULL,
CONSTRAINT fk_Application_AgentFirmName FOREIGN KEY (AgentFirmName)
REFERENCES Agent (FirmName)
ON UPDATE CASCADE ON DELETE SET NULL
);
 *
 */


public class ApplicationDao {
	
	protected ConnectionManager connectionManager;

	private static ApplicationDao instance = null;
	protected ApplicationDao() {
		connectionManager = new ConnectionManager();
	}
	public static ApplicationDao getInstance() {
		if(instance == null) {
			instance = new ApplicationDao();
		}
		return instance;
	}

	public Application create(Application application) throws SQLException {
		String insertApplication =
			"INSERT INTO Application(DecisionDate,CaseStatus,CaseReceivedDate,Refile,OriginalFileDate,Scheduled,EmployerName,ApplicantID,AgentFirmName) " +
			"VALUES(?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			// Application has an auto-generated key. So we want to retrieve that key.
			insertStmt = connection.prepareStatement(insertApplication,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, blogPost.getTitle());
			// Note: for the sake of simplicity, just set Picture to null for now.
			insertStmt.setNull(2, Types.BLOB);
			insertStmt.setString(3, blogPost.getContent());
			insertStmt.setBoolean(4, blogPost.isPublished());
			insertStmt.setTimestamp(5, new Timestamp(blogPost.getCreated().getTime()));
			insertStmt.setString(6, blogPost.getBlogUser().getUserName());
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			// For more details, see:
			// http://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-last-insert-id.html
			resultKey = insertStmt.getGeneratedKeys();
			int postId = -1;
			if(resultKey.next()) {
				postId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			blogPost.setPostId(postId);
			return blogPost;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}

	/**
	 * Update the content of the BlogPosts instance.
	 * This runs a UPDATE statement.
	 */
	public BlogPosts updateContent(BlogPosts blogPost, String newContent) throws SQLException {
		String updateBlogPost = "UPDATE BlogPosts SET Content=?,Created=? WHERE PostId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateBlogPost);
			updateStmt.setString(1, newContent);
			// Sets the Created timestamp to the current time.
			Date newCreatedTimestamp = new Date();
			updateStmt.setTimestamp(2, new Timestamp(newCreatedTimestamp.getTime()));
			updateStmt.setInt(3, blogPost.getPostId());
			updateStmt.executeUpdate();

			// Update the blogPost param before returning to the caller.
			blogPost.setContent(newContent);
			blogPost.setCreated(newCreatedTimestamp);
			return blogPost;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	/**
	 * Delete the BlogPosts instance.
	 * This runs a DELETE statement.
	 */
	public BlogPosts delete(BlogPosts blogPost) throws SQLException {
		// Note: BlogComments has a fk constraint on BlogPosts with the reference option
		// ON DELETE CASCADE. So this delete operation will delete all the referencing
		// BlogComments.
		String deleteBlogPost = "DELETE FROM BlogPosts WHERE PostId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteBlogPost);
			deleteStmt.setInt(1, blogPost.getPostId());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the BlogPosts instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	/**
	 * Get the BlogPosts record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single BlogPosts instance.
	 * Note that we use BlogUsersDao to retrieve the referenced BlogUsers instance.
	 * One alternative (possibly more efficient) is using a single SELECT statement
	 * to join the BlogPosts, BlogUsers tables and then build each object.
	 */
	public BlogPosts getBlogPostById(int postId) throws SQLException {
		String selectBlogPost =
			"SELECT PostId,Title,Picture,Content,Published,Created,UserName " +
			"FROM BlogPosts " +
			"WHERE PostId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectBlogPost);
			selectStmt.setInt(1, postId);
			results = selectStmt.executeQuery();
			BlogUsersDao blogUsersDao = BlogUsersDao.getInstance();
			if(results.next()) {
				int resultPostId = results.getInt("PostId");
				String title = results.getString("Title");
				String picture = results.getString("Picture");
				String content = results.getString("Content");
				boolean published = results.getBoolean("Published");
				Date created =  new Date(results.getTimestamp("Created").getTime());
				String userName = results.getString("UserName");
				
				BlogUsers blogUser = blogUsersDao.getBlogUserFromUserName(userName);
				BlogPosts blogPost = new BlogPosts(resultPostId, title, picture, content,
					published, created, blogUser);
				return blogPost;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}

	/**
	 * Get the all the BlogPosts for a user.
	 */
	public List<BlogPosts> getBlogPostsForUser(BlogUsers blogUser) throws SQLException {
		List<BlogPosts> blogPosts = new ArrayList<BlogPosts>();
		String selectBlogPosts =
			"SELECT PostId,Title,Picture,Content,Published,Created,UserName " +
			"FROM BlogPosts " +
			"WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectBlogPosts);
			selectStmt.setString(1, blogUser.getUserName());
			results = selectStmt.executeQuery();
			while(results.next()) {
				int postId = results.getInt("PostId");
				String title = results.getString("Title");
				String picture = results.getString("Picture");
				String content = results.getString("Content");
				boolean published = results.getBoolean("Published");
				Date created =  new Date(results.getTimestamp("Created").getTime());
				BlogPosts blogPost = new BlogPosts(postId, title, picture, content, published,
					created, blogUser);
				blogPosts.add(blogPost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return blogPosts;
	}

}
