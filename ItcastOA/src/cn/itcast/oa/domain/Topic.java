package cn.itcast.oa.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_topic")
public class Topic extends Article {

	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_BEST = 1;
	public static final int TYPE_TOP = 2;
	private String title;
	private int type;
	private Forum forum;
	private Set<Reply> replies;
	private int replyCount;
	private Reply lastReply;
	private Date lastUpdateTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name="forum_id")
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	@OneToMany(mappedBy="topic")
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	@ManyToOne
	@JoinColumn(name="last_reply_id",unique=true)
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	
	@Column(columnDefinition="timestamp")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
