package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Client;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ���� USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ����
 */
public class ClientDAO {
	private JDBCUtil jdbcUtil = null;

	public ClientDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil ��ü ����
	}

	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
	 */
	public int create(Client client) throws SQLException {
		String sql = "INSERT INTO CLIENT (CLIENTID, CLIENTNAME, CLIENTPHONE, CLIENTPASSWD, ADDRGU, ADDRDONG) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { client.getClientId(), client.getName(), client.getPhone(), client.getPassword(),
				client.getAddrgu(), client.getAddrdong() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil �� insert���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ������ ����� ������ ����.
	 */
	public int update(Client client) throws SQLException {
		String sql = "UPDATE CLIENT "
				+ "SET CLIENTNAME=?, CLIENTPHONE=?, CLIENTPASSWD=?, CLIENTADDRGU=?, CLIENTADDRDONG=? "
				+ "WHERE CLIENTID=?";
		Object[] param = new Object[] { client.getName(), client.getPhone(), client.getPassword(), client.getAddrgu(),
				client.getAddrdong(), client.getClientId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil�� update���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String userId) throws SQLException {
		String sql = "DELETE FROM CLIENT WHERE CLIENTID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId }); // JDBCUtil�� delete���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ �����Ͽ� ��ȯ.
	 */
	public Client findUser(String userId) throws SQLException {
		String sql = "SELECT CLIENTNAME, CLIENTPHONE, CLIENTPASSWD, ADDRGU, ADDRDONG " + "FROM CLIENT "
				+ "WHERE CLIENTID=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId }); // JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Client client = new Client(
						userId, rs.getString("CLIENTNAME"), rs.getString("CLIENTPHONE"), rs.getString("CLIENTPASSWD"),
						rs.getString("ADDRGU"), rs.getString("ADDRDONG"));
				return client;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<Client> findUserList() throws SQLException {
		String sql = "SELECT CLIENTID, CLIENTNAME, CLIENTPHONE, CLIENTPASSWD, ADDRGU, ADDRDONG " + "FROM CLIENT "
				+ "ORDER BY CLIENTID";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil�� query�� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			List<Client> clientList = new ArrayList<Client>(); // User���� ����Ʈ ����
			while (rs.next()) {
				Client client = new Client( // User ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getString("CLIENTID"), rs.getString("CLIENTNAME"), rs.getString("CLIENTPHONE"),
						rs.getString("CLIENTPASSWD"), rs.getString("ADDRGU"), rs.getString("ADDRDONG"));
				clientList.add(client); // List�� User ��ü ����
			}
			return clientList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ� �ش��ϴ� ����� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<Client> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT CLIENTID, CLIENTNAME, CLIENTPHONE, CLIENTPASSWD, ADDRGU, ADDRDONG " + "FROM CLIENT "
				+ "ORDER BY CLIENTID";
		jdbcUtil.setSqlAndParameters(sql, null, // JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE, // cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			int start = ((currentPage - 1) * countPerPage) + 1; // ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) { // Ŀ���� ���� ������ �̵�
				List<Client> clientList = new ArrayList<Client>(); // User���� ����Ʈ ����
				do {
					Client client = new Client( // User ��ü�� �����Ͽ� ���� ���� ������ ����
							rs.getString("CLIENTID"), rs.getString("CLIENTNAME"), rs.getString("CLIENTPHONE"),
							rs.getString("CLIENTPASSWD"), rs.getString("ADDRGU"), rs.getString("ADDRDONG"));
					clientList.add(client); // ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));
				return clientList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return null;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����ڰ� �����ϴ��� �˻�
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM CLIENT WHERE CLIENTID=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId }); // JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource ��ȯ
		}
		return false;
	}
}
