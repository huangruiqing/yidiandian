package com.example.demo.H2;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @ClassName DemoInfoRepository
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/18 19:23
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {
    /*@Override
    public <S extends DemoInfo> S save(S s) {
        return null;
    }

    @Override
    public <S extends DemoInfo> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<DemoInfo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<DemoInfo> findAll() {
        return null;
    }

    @Override
    public Iterable<DemoInfo> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DemoInfo demoInfo) {

    }

    @Override
    public void deleteAll(Iterable<? extends DemoInfo> iterable) {

    }

    @Override
    public void deleteAll() {

    }*/
}
