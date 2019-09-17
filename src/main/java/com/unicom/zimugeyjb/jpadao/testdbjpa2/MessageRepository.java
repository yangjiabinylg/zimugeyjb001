package com.unicom.zimugeyjb.jpadao.testdbjpa2;

import com.unicom.zimugeyjb.pojo.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: zimugeyjb <br/>
 * @Date: 2019/9/17 16:16 <br/>
 * @Author: yangjiabin
 */
public interface MessageRepository extends JpaRepository<Message,Long> {



}
