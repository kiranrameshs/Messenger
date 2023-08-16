package com.kiran.messenger.labels;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CassandraRepository<Label, String> {
}
