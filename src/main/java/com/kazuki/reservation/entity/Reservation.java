
package com.kazuki.reservation.entity;

// データベースのテーブルとJavaクラスを対応させるためのアノテーション
import jakarta.persistence.Entity;

// データベースにIDを自動採番させるためのアノテーション
import jakarta.persistence.GeneratedValue;

// IDの自動採番方式を指定するための定数を使う
import jakarta.persistence.GenerationType;

// このフィールドが主キー（データを一意に識別する値）であることを示す
import jakarta.persistence.Id;

// このクラスをデータベースのテーブルに対応させる
@Entity
public class Reservation {

    // 予約を一意に識別するID
    @Id

    // データベースへの登録時にIDを自動採番する
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 予約者の名前を保存するフィールド
    private String name;

    // 予約日を保存するフィールド（現在は文字列として扱う）
    private String date;

    // 引数なしコンストラクタ
    // JPAがデータベースから取得したデータをもとに
    // Reservationオブジェクトを生成するときに必要
    public Reservation() {
    }

    // 引数ありコンストラクタ
    // ID・名前・予約日を指定してオブジェクトを生成する
    // 例：new Reservation(1, "山田太郎", "2026-07-20")
    public Reservation(Integer id, String name, String date) {
        this.id = id;       // 引数のIDをフィールドに設定
        this.name = name;   // 引数の名前をフィールドに設定
        this.date = date;   // 引数の予約日をフィールドに設定
    }

    // IDを取得するメソッド
    public Integer getId() {
        return id;
    }

    // IDを設定するメソッド
    public void setId(Integer id) {
        this.id = id;
    }

    // 名前を取得するメソッド
    public String getName() {
        return name;
    }

    // 名前を設定するメソッド
    public void setName(String name) {
        this.name = name;
    }

    // 予約日を取得するメソッド
    public String getDate() {
        return date;
    }

    // 予約日を設定するメソッド
    public void setDate(String date) {
        this.date = date;
    }
}
