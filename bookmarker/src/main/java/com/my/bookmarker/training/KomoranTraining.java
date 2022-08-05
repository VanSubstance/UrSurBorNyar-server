package com.my.bookmarker.training;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

import java.util.List;

public class KomoranTraining {
    public static void main(String[] args) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        String strToAnalyze = "���� ���ƿ�\r\n"
        		+ "���� �ΰ� ���� ��ϳ��� �״�\r\n"
        		+ "�״��� �����\r\n"
        		+ "���� ���� ������ ���\r\n"
        		+ "�״���ϴ�\r\n"
        		+ "�¾ ó������\r\n"
        		+ "���� ������ ���\r\n"
        		+ "��õ ���� ���Ƶ�\r\n"
        		+ "���� �ϳ����� �׷� ���\r\n"
        		+ "���� ����̶�� ������ ���ƿ�\r\n"
        		+ "�ٽ� �����غ��� �ູ�� ���ε�\r\n"
        		+ "�츮 ����ϴ� ��ŭ\r\n"
        		+ "���� ����������\r\n"
        		+ "�׳� �׳� �׳� �̴��\r\n"
        		+ "�������\r\n"
        		+ "�ٺ����ϴ�\r\n"
        		+ "���� �� �����\r\n"
        		+ "�ٶ� ���� ���\r\n"
        		+ "Ȥ�� ������ ����\r\n"
        		+ "�׶� �׶� �׳� ���� �Ϳ�\r\n"
        		+ "���� ����̶�� ������ ���ƿ�\r\n"
        		+ "�ٽ� �����غ��� �ູ�� ���ε�\r\n"
        		+ "�츮 ����ϴ� ��ŭ\r\n"
        		+ "���� ����������\r\n"
        		+ "�׳� �׳� �׳� �̴��\r\n"
        		+ "�������\r\n"
        		+ "�״� �� �� ���� ��\r\n"
        		+ "�������� �� ����\r\n"
        		+ "���� ������ ���ε�\r\n"
        		+ "���� �翡 �־��\r\n"
        		+ "�������� ���ƿ�\r\n"
        		+ "���� ����Դϴ�\r\n"
        		+ "����� ���ĵ� �Ʊ��� ���� ���\r\n"
        		+ "�״��� �״ϱ�\r\n"
        		+ "�츮 ����ϴ� ��ŭ\r\n"
        		+ "���� ����������\r\n"
        		+ "�׳� �׳� �׳� �̴�� �������";

        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

//        System.out.println(analyzeResultList.getPlainText());

        List<Token> tokenList = analyzeResultList.getTokenList();
        for (Token token : tokenList) {
        	if (token.getPos().contains("NN")) System.out.format("%s / %s\n", token.getMorph(), token.getPos());
        }

    }}
