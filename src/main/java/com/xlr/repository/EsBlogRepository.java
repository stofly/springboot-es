package com.xlr.repository;

import com.xlr.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author sixkery
 * @date 2019/11/24
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {
}
